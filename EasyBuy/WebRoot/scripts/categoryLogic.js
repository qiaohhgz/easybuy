//window.onload = display;
dwr.util.useLoadingMessage();
function display() {
	jCategory.getCategroy(function(data) {
		for ( var i = 0; i < data.length; i++) {
			var c = data[i];
			if (c.categoryFather != null) {
				addRow(c.id, c.name, c.categoryFather.id);
			}
		}
	});
}

function addRow(id, name, fid) {
	var tab = document.getElementById("c");
	var row = tab.insertRow(tab.rows.length);
	row.insertCell(row.cells.length).innerHTML = id;
	row.insertCell(row.cells.length).innerHTML = name;
	row.insertCell(row.cells.length).innerHTML = fid;
}

function deleteAll() {
	var tab = document.getElementById("c");
	tab.innerHTML = "";
}
function $(el) {
	return document.getElementById(el);
}
function addNews() {
	jNews.addNews({
		title : $("title").value,
		content : $("content").value
	}, function(id) {
		alert(id);
	});
}