<?php include('header.php'); ?>

    <!-- ***** Learn Area Start ***** -->
    <section class="learnword_area clearfix" id="home" >
        <div class="container h-100 ">

            <div class="row h-100 align-items-center" id="learn_group">
                    
                <?php foreach ($vol as $row):  ?>
                  <div class="card col-sm-8 offset-sm-2 col-lg-5 offset-lg-3 card-block text-center mySlides" onload="Rvoice()" id="word_card">
                                <div class="word_volume">
                                  <div class="word_volume_icon"><img src="<?php echo base_url(); ?>img/learn-img/icon-volume.png" onclick='responsiveVoice.speak("<?= $row->Word; ?>");' type='button'></img>
                                  </div>
                                </div>
                                <?php echo '<img src="data:image/png;base64,'.base64_encode($row->Pic).'" class="card-title mx-auto img-fluid" id="word_img" ></img>'; ?>
                                <hr>
                                <p name="Volcabulary" id="word_name" class="Volcabulary"><?= $row->Word; ?></p>
                                <p name="Mean" id="word_type" class="type"><?= $row->WordType; ?></p>
                                <p name="Mean" id="word_spell" class="spell"><?= $row->Spell; ?></p>
                                <p name="Mean" id="word_mean" class="Mean"><?= $row->Mean; ?></p>
                                <!-- <a href="" id="word_ex" class="card-block col-md-12 col-lg-12"><?= $row->Ex; ?></a> -->
                  </div>
                <?php endforeach ?>
                    <button class="btn btn-dark col-sm-4 offset-sm-1 col-lg-2 offset-lg-3" id="btn-previous" style="visibility:hidden" onclick="plusDivs(-1)"><= Quay lại</button>
                    <button class="btn btn-success col-sm-4 offset-sm-2 col-lg-2 offset-lg-1" id="btn-next" onclick="plusDivs(1);">Tiếp Theo =></button>   
                    <button class="btn btn-danger offset-sm-0 col-sm-4 col-lg-2 cd-popup-trigger" id="btn-end" style="visibility:hidden" >KẾT THÚC</button>
            </div>
        </div>
        <div class="cd-popup" role="alert">
          <div class="cd-popup-container">
            <img id="cd-popup-img" src="<?php echo base_url(); ?>img/learn-img/icon-congra.png"></img>
            <h1 id="cd-popup-congra">Chúc mừng</h1>
            <p id="cd-popup-count">Bạn đã học được <span id="showCount"></span> từ vựng</p>
            <p id="cd-popup-ask">Bạn có muốn học tiếp không ???</p>
            <br>
              <ul class="cd-buttons">
                <li><a href="<?= base_url(); ?>index.php/demolistlearn">Để Sau</a></li>
                <li><a href="#0">Học tiếp</a></li>
              </ul>
            <a href="#0" class="cd-popup-close img-replace"></a>
          </div> <!-- cd-popup-container -->
        </div> <!-- cd-popup -->
    </section>
    <!-- ***** Learn Area End ***** -->
    <?php include('footer.php'); ?>


