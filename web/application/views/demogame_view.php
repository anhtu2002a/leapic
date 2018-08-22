<?php include('header.php'); ?>

    <!-- ***** Game Area Start ***** -->
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
    </section>
    <!-- ***** Game Area End ***** -->
    
    <?php include('footer.php'); ?>