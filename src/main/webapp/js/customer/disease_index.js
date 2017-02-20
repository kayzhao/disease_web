$(function() {
	
});

function initNavigation(href) {
	var $el = $('a[href="' + href + '"]'), $prev, $next;

	$('.ribbon a').attr(
			'href',
			'https://github.com/wenzhixin/bootstrap-table-examples/blob/master/'
					+ href);

	if (!$el.length) {
		return;
	}
	$prev = $el.parent().prev('li');
	$next = $el.parent().next('li');
	$('.navigation a').hide();

	if ($prev.text()) {
		$('.navigation .previous').show().attr('href',
				$prev.find('a').attr('href')).find('span').text($prev.text());
	}
	if ($next.text()) {
		$('.navigation .next').show()
				.attr('href', $next.find('a').attr('href')).find('span').text(
						$next.text());
	}
}