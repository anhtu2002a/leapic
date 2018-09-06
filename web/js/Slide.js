	var myWord = document.getElementsByClassName('words_card');
    var $volcabulary; 
    var $key =1;

    function changeWord() {
        myWord.setAttribute("src", $volcabulary[$key]);
        $key++;
    }