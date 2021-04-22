function goPage(url, pages, lines){
	url += '?' + "pages=" + pages + "&lines=" + lines;
	location.href = url;
}