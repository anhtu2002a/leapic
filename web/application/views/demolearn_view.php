<?php include('header.php'); ?>

    <!-- ***** Learn Area Start ***** -->
    <section class="learnword_area clearfix" id="home" >
        <div class="container h-100 ">

            <div class="row h-100 align-items-center" id="learn_group">
                <div class="card col-sm-8 offset-sm-2 col-lg-5 offset-lg-3 card-block text-center mySlides" id="word_card">
                <?php foreach ($tuvung as $key => $value):  ?>
                                <?php var_dump($key); ?>
                                <?php echo '<img src="data:image/png;base64,'.base64_encode($value['Pic']).'" class="card-title mx-auto img-fluid" id="word_img" ></img>'; ?>
                                <hr>
                                <p name="Volcabulary" id="word_name" class="Volcabulary"><?= $value['Word'] ?></p>
                                <p name="Mean" id="word_mean" class="Mean"><?= $value['Mean'] ?></p>
                                <a href="" id="word_ex" class="card-block col-md-12 col-lg-12"><?= $value['Ex'] ?></a>
                                
                <?php endforeach ?>
                </div> 
                    <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
                    <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
            </div>
        </div>
    </section>
    <!-- ***** Learn Area End ***** -->
    <?php include('footer.php'); ?>

<script>
    var slideIndex = 1;
    showDivs(slideIndex);

    function plusDivs(n) {
      showDivs(slideIndex += n);
    }

    function showDivs(n) {
      var i;
      var x = document.getElementsByClassName("mySlides");
      if (n > x.length) {slideIndex = 1}    
      if (n < 1) {slideIndex = x.length}
      for (i = 0; i < x.length; i++) {
         x[i].style.display = "none";  
      }
      x[slideIndex-1].style.display = "block";  
    }
</script>
