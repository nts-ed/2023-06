const DELETE_MESSAGE = "前画面に戻りますが、大丈夫でしょうか。"
$('.delete-action').click(function() {
	if(!confirm(DELETE_MESSAGE)){
		return false;
	}
});