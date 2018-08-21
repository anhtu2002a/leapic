<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Colorlib App - App Landing Page</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="<?php echo base_url(); ?>style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="<?php echo base_url(); ?>css/responsive.css" rel="stylesheet">
    <?php define('IMAGE_DIR','images/'); ?>

</head>

<body>
    <!-- Preloader Start -->
    <div id="preloader">
        <div class="colorlib-load"></div>
    </div>

    <!-- ***** Header Area Start ***** -->
    <header class="header_area animated">
        <div class="container-fluid">
            <div class="row align-items-center">
                <!-- Menu Area Start -->
                <div class="col-12 col-lg-10">
                    <div class="menu_area">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <!-- Logo -->
                            <a class="navbar-brand" href="#">Ca.</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ca-navbar" aria-controls="ca-navbar" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                            <!-- Menu Area -->
                            <div class="collapse navbar-collapse" id="ca-navbar">
                                <ul class="navbar-nav ml-auto" id="nav">
                                    <li class="nav-item active"><a class="nav-link" href="#home">Home</a></li>
                                </ul>
                                <div class="sing-up-button d-lg-none">
                                    <a href="#">Sign Up Free</a>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
                <!-- Signup btn -->
                <div class="col-12 col-lg-2">
                    <div class="sing-up-button d-none d-lg-block">
                        <a href="#">Sign Up Free</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

    <!-- ***** Wellcome Area Start ***** -->
    <section class="wellcome_area clearfix" id="home">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <!-- <div class="row"> -->
                <div class="col-12 col-md">
                    
                        <div class="card">
                        <div class="card-block">
                            <div>
                                <span name="question" id="question" class="question">Nói Hello đi nè :D</span>
                            </div>
                            <div>
                                <!-- <span name="question" id="question" class="question">Nói Hello đi nè :D</span> -->
                                <span name="final_span" id="final_span" class="final" value=""> </span>
                                <span name="interim_span" id="interim_span" class="interim"> </span>
                            </div>
                            <div>
                                <img src="<?php echo base_url(); ?>img/game-img/Ans-img.png" id="kq"/>
                            </div>
                            <div>    
                                <img href="#" src="<?php echo base_url(); ?>img/game-img/recording-micro-icon.png" id="start_button" onclick="startDictation(event)">
                                </img> 
                                <span id="recording"></span>
                            </div>
                        </div>
                        </div> 
                <!-- </div> -->
                </div>
            </div>
        </div>
        <!-- Welcome thumb -->
        <div class="welcome-thumb wow fadeInDown" data-wow-delay="0.5s">
          <!-- <img src="img/bg-img/welcome-img.png" alt=""> -->
         <?php 
            echo "<img src='https://drive.google.com/uc?id=19NLkOpdtKnM6RF-H3qSVtFkqRxyfYS12' />"; 
          ?> 
        </div>
    </section>
    <!-- ***** Wellcome Area End ***** -->


 

    <!-- ***** Footer Area Start ***** -->
    <footer class="footer-social-icon text-center section_padding_70 clearfix">
        <!-- footer logo -->
        <div class="footer-text">
            <h2>Ca.</h2>
        </div>
        <!-- social icon-->
        <div class="footer-social-icon">
            <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
            <a href="#"><i class="active fa fa-twitter" aria-hidden="true"></i></a>
            <a href="#"> <i class="fa fa-instagram" aria-hidden="true"></i></a>
            <a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
        </div>
        <div class="footer-menu">
            <nav>
                <ul>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Terms &amp; Conditions</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </div>
        <!-- Foooter Text-->
        <div class="copyright-text">
            <!-- ***** Removing this text is now allowed! This template is licensed under CC BY 3.0 ***** -->
            <p>Copyright ©2017 Ca. Designed by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
        </div>
    </footer>
    <!-- ***** Footer Area Start ***** -->

    <!-- Jquery-2.2.4 JS -->
    <script src="<?php echo base_url(); ?>js/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="<?php echo base_url(); ?>js/popper.min.js"></script>
    <!-- Bootstrap-4 Beta JS -->
    <script src="<?php echo base_url(); ?>js/bootstrap.min.js"></script>
    <!-- All Plugins JS -->
    <script src="<?php echo base_url(); ?>js/plugins.js"></script>
    <!-- Slick Slider Js-->
    <script src="<?php echo base_url(); ?>js/slick.min.js"></script>
    <!-- Footer Reveal JS -->
    <script src="<?php echo base_url(); ?>js/footer-reveal.min.js"></script>
    <!-- Active JS -->
    <script src="<?php echo base_url(); ?>js/active.js"></script>
    <!-- SpeechAPI JS -->
    <script src="<?php echo base_url(); ?>js/SpeechAPI.js"></script>

    <script src="<?php echo base_url(); ?>js/test.js"></script>
</body>

</html>
