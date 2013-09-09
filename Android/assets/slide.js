$(document).ready(function(){
 
        $(".slidingDiv").hide();
        $(".show_hide").show();
 
    $('.show_hide').click(function(){
		$('#div'+$(this).attr('target')).slideToggle();
    });
});