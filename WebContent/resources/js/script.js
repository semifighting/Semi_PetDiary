function goPage(url, key, pages, lines){
	url += "?" +  "command=" + key + "&pages=" + pages + "&lines=" + lines;
	location.href = url;
}
