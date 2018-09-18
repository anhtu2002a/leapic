<?php include('header.php'); ?>

    <!-- ***** Listlearn Area Start ***** -->
    <section class="listlearn_area clearfix" id="home" >
        <div class="container h-100">
            <div class="row h-100 align-items-center" id="list_group">
                <?php foreach ($danhsachbaihoc as $key => $value): ?>
                    <div class="col-4 col-xs-2" id="list_screen">
                    <div class="card card-block text-center" id="list_card">
                        <?php echo '<a href="demolistlearn/detailWords/'.$value['ID'].'"><img  src="data:image/png;base64,'.base64_encode($value['Icon1']).'" class="card-title mx-auto img-fluid" id="category_img"></img></a>'; ?>
                        <p class="card-text" id="category_name"> <?= $value['Name'] ?> </p>
                    </div>
                    </div>
                    
                <?php endforeach ?>
            </div>
        </div>
    </section>
    <!-- ***** Listlearn Area End ***** -->
    
    <?php include('footer.php'); ?>
