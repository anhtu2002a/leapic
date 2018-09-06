<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>LeaPic - Learn English by Picture</title>

    <!-- Favicon -->
    <link rel="icon" href="/WebAppLeng/img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="<?php echo base_url(); ?>style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="<?php echo base_url(); ?>css/responsive.css" rel="stylesheet">
    
    <link href="<?php echo base_url(); ?>dist/css/swiper.min.css" rel="stylesheet">
    <style>
    html, body {
      position: relative;
      height: 100%;
    }
    body {
      background: #eee;
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color:#000;
      margin: 0;
      padding: 0;
    }
    .swiper-container {
      width: 100%;
      height: 100%;
    }
    .swiper-slide {
      text-align: center;
      font-size: 18px;
      background: #fff;
      /* Center slide text vertically */
      display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
    }
  </style>

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
                <div class="col-10 col-lg-10">
                    <div class="menu_area">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <!-- Logo -->
                            <a class="navbar-brand" href="<?= base_url(); ?>index.php/homepage">LeaP.</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ca-navbar" aria-controls="ca-navbar" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                            <!-- Menu Area -->
                            <div class="collapse navbar-collapse col-lg-10" id="ca-navbar">
                                <ul class="navbar-nav ml-auto" id="nav">
                                    <li class="nav-item"><a class="nav-link" href="<?= base_url(); ?>index.php/homepage">Home</a></li>
                                    <li class="nav-item"><a class="nav-link" href="<?= base_url(); ?>index.php/demolistlearn">Learn</a></li>
                                    <li class="nav-item"><a class="nav-link" href="<?= base_url(); ?>index.php/demogame">Game</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#features">Features</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#screenshot">Screenshot</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#team">Team</a></li>
                                    <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
                                </ul>
                                <!-- Reponsive Buton -->
                                <div class="sing-up-button d-lg-none d-md-none">
                                    <a href="#">Log in</a>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
                <!-- Signup btn -->
                <div class="col-12 col-lg-2">
                    <div class="sing-up-button d-none d-lg-block">
                        <a href="#">Log In</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->