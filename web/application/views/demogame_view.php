<?php include('header.php'); ?>

    <!-- ***** Game Area Start ***** -->
    <section class="wellcome_area clearfix" id="home">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <!-- <div class="row"> -->
                <div class="col-12 col-sm-12 offset-sm-2 col-md-7 offset-md-3 col-lg-6 offset-lg-4" id="game_screen" >
                    
                        <div class="card d-inline-flex " >
                        <div class="card-block col-md-12 col-lg-12" style="" style="" id="game_card">
                            <div class="alert" style="background-color: #CFE2E8">
                                <span name="question" id="question" class="question">Nói Hello đi nè :D</span> 
                                <span name="final_span" id="final_span" class="final" value=""></span>
                                <span name="interim_span" id="interim_span" class="interim"> </span>
                            </div>
                            <div class="" style="background-color: #CFE2E8" id="Rec_img">
                                <img src="<?php echo base_url(); ?>img/game-img/Ans-img.png" id="kq"/>
                            </div>
                            <div class="alert" style="background-color: #CFE2E8; margin-top: 50px;" id="rec_action">    
                                <img class="" href="#" src="<?php echo base_url(); ?>img/game-img/microphone1.png" id="start_button" onclick="startDictation(event)">
                                </img> 
                                <span id="recording"></span>
                            </div>
                        </div>
                <!-- </div> -->
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Game Area End ***** -->
    
    <?php include('footer.php'); ?>