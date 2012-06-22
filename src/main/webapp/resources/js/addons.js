var timer;

function generate_preview() {
	$('#img_preview img').attr('src', 'http://store.cycleonweb.com/Assets/Cycle/Images/ajax-loader.gif');
	
	timer = setTimeout(function() {
		$('#img_preview img').attr('src', $('input[id$="coverUrl"]').val());
	}, 2000);
}

function preview_error() {
	$('#img_preview img').attr('src', 'http://upload.wikimedia.org/wikipedia/en/d/d6/Preview_icon.png');
	clearTimeout(timer);
}

function set_default_img(elem) {
	elem.attr('src', 'http://upload.wikimedia.org/wikipedia/en/d/d6/Preview_icon.png');
}