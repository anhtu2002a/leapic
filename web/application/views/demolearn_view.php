<?php include('header.php'); ?>

    <!-- ***** Game Area Start ***** -->
    <section class="wellcome_area clearfix" id="home">
        <div class="container h-100">
            <div class="row h-100 align-items-center ">
                <div class="col-12 col-md-12 offset-md-4 col-sm-12 offset-sm-2 " id="learn_screen" >
                    <?php foreach ($tuvung as $key => $value): ?>
                        <div class="card-block col-md-12 col-lg-5 rounded" style="background-color: #CFE2E8">
                        <div>
                            <div class="col-12" style="background-color: #CFE2E8;" id="Learn_img" >
                                <?php echo '<img src="data:image/png;base64,'.base64_encode($value['Word_Pic']).'" id="pic" ></img>'; ?>
                                <!-- <img src="<?php echo base_url(); ?>img/learn-img/vehicle/bicycle-img.png" id="pic"/> -->
                                <hr>
                            </div>
                            <div id="Learn_vol" class="text-center">
                                <span name="Volcabulary" id="Volcabulary" class="Volcabulary" style="font-weight: bold; font-size: 30px; font-family:sans-serif;"><?= $value['Word_Name'] ?></span>
                                <br>
                                <span name="Mean" id="Mean" class="Mean" style="font-weight: bold; font-size: 30px; font-family:sans-serif;"><?= $value['Word_Mean'] ?></span>
                            </div>
                            <div id="Learn-Ex" class="text-center" style="font-family: ">
                                <a href="" id="View_Example" class="card-block col-md-12 col-lg-12"><?= $value['Word_Ex'] ?></a>
                            </div>
                        </div>
                    </div>    
                    <?php endforeach ?>
                    
                </div>       
            </div>
        </div>
    </section>
    <!-- ***** Game Area End ***** -->
    
    <?php include('footer.php'); ?>
