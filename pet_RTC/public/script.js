const socket = io('/')
const videoGrid = document.getElementById('video-grid')
const peervideoGrid = document.getElementById('peer-video-grid')

const myPeer = new Peer()

const myVideo = document.createElement('video')
myVideo.muted = true
const peers = {}




navigator.mediaDevices.getUserMedia({
    video: true,
    audio: true
}).then(stream=>{
    window.localStream = stream
    addVideoStream(myVideo, stream)
    myPeer.on('call', call =>{
        call.answer(stream)
        const video = document.createElement('video')
        call.on('stream', userVideoStream=>{
            peeraddVideoStream(video, userVideoStream)
        })
    })
    
    socket.on('user-connected', userId => {
        // user is joining
        setTimeout(() => {
        // user joined
        connectToNewUser(userId, stream)
        }, 1000)
    })
})

socket.on('user-disconnected', userId=> {
    if (peers[userId]) {peers[userId].close()}
})


myPeer.on('open',id =>{
    socket.emit('join-room', ROOM_ID, id)
})

function connectToNewUser(userId, stream){
    const call = myPeer.call(userId, stream)
    const video = document.createElement('video')
    call.on('stream', userVideoStream => {
        peeraddVideoStream(video, userVideoStream)
    })
    call.on('close', () => {
        video.remove()
    })
    peers[userId] = call
}


function addVideoStream(video, stream){
    video.srcObject = stream
    video.addEventListener('loadedmetadata', ()=>{
        video.play()
    })
    videoGrid.append(video)
}


function peeraddVideoStream(video, stream){
    video.srcObject = stream
    video.addEventListener('loadedmetadata', ()=>{
        video.play()
    })
    peervideoGrid.append(video)
}

