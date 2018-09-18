<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Demolistlearn extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->model('demolistlearn_model');
	}

	public function index()
	{
		//$this->load->view('demolistlearn_view');
		//load model
		//goi ham loadCategory trong model
		$danhsach = $this->demolistlearn_model->loadCategory();
		$danhsach = array('danhsachbaihoc' => $danhsach); // bien danhsach thanh mang voi key la danhsachbaihoc
		//load view kem du lieu
		//echo "<pre>";
		//var_dump($danhsach);
		$this->load->view('demolistlearn_view', $danhsach);
	}
	public function detailWords($idword)
	{
		$vol['vol'] = $this -> demolistlearn_model -> getWordsByID($idword);
		// $vol = array('tuvung' => $vol);
		// echo "<pre>";
		// var_dump($volcabulary);

		$this->load->view('demolearn_view', $vol, FALSE);
	}
	public function markasLearned()
	{
		$data = $this->demolistlearn_model->markLearnedWord();
		echo json_encode($data);
	}
}

/* End of file demolistlearn.php */
/* Location: ./application/controllers/demolistlearn.php */