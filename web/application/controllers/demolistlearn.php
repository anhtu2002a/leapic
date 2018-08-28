<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolistlearn extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		//$this->load->view('demolistlearn_view');
		//load model
		$this->load->model('demolistlearn_model');	
		//goi ham getdatabase trong model
		$danhsach = $this->demolistlearn_model->getdatabase();
		$danhsach = array('danhsachbaihoc' => $danhsach); // bien danhsach thanh mang voi key la danhsachbaihoc
		//load view kem du lieu
		//echo "<pre>";
		//var_dump($danhsach);
		$this->load->view('demolistlearn_view', $danhsach, FALSE);
	}
	

}

/* End of file demolistlearn.php */
/* Location: ./application/controllers/demolistlearn.php */