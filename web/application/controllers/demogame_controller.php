<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demogame_controller extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		//load view
		//$this->load->view('demogame_view'); 
		//load model bang ham getdatabase trong model
		$this->load->model('demogame_model');
		$dulieu = $this->demogame_model->getdatabase();
		$dulieu = array('dulieutucontroller' => $dulieu); // bien du lieu thanh mang voi key la dulieucontroller
		$this->load->view('demogame_view', $dulieu, FALSE);
	}
}

/* End of file demogame_controller.php */
/* Location: ./application/controllers/demogame_controller.php */