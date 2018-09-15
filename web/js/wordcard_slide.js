    var showCount = $("#showCount");
    var slideIndex = 1;
    var slideCount = 1;
    var slideTotal = document.getElementsByClassName("mySlides").length;
    console.log(slideTotal);
    showDivs(slideIndex);

    function plusDivs(n) {
      showDivs(slideIndex += n);
      slideCount = slideCount < slideTotal ? slideCount + Number(n) : 1;
      if(slideCount < 1){
        slideCount = slideTotal;
      }else{
        document.getElementById("btn-previous").style.visibility = 'visible';
      }
      if(slideCount == slideTotal){
        document.getElementById("btn-next").style.visibility = 'hidden';
        document.getElementById("btn-end").style.visibility = 'visible';
      }else{
        document.getElementById("btn-end").style.visibility = 'hidden';
        document.getElementById("btn-next").style.visibility = 'visible';
      }
      if(slideCount == 1){
        document.getElementById("btn-previous").style.visibility = 'visible';
      }
      console.log(slideCount);
    }

    function showDivs(n) {
      var i;
      var x = document.getElementsByClassName("mySlides");
      if (n > x.length) {
        slideIndex = 1
      }    
      if (n < 1) {
        slideIndex = x.length
      }
      for (i = 0; i < x.length; i++) {
         x[i].style.display = "none";  
      }
      x[slideIndex-1].style.display = "block";
    }

    jQuery(document).ready(function($){
      //open popup
      $('.cd-popup-trigger').on('click', function(event){
        event.preventDefault();
        $('.cd-popup').addClass('is-visible');
        showCount.text(slideCount);
      });
      
      //close popup
      $('.cd-popup').on('click', function(event){
        if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') ) {
          event.preventDefault();
          $(this).removeClass('is-visible');
        }
      });
      $('#cd-popup-cancel').on('click', function(event){
        if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') ) {
          event.preventDefault();
          $(this).removeClass('is-visible');
        }
      });
      //close popup when clicking the esc keyboard button
      $(document).keyup(function(event){
          if(event.which=='27'){
            $('.cd-popup').removeClass('is-visible');
          }
        });
    });