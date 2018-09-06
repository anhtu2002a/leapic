<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Homepage extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		$this->load->view('homepage_view');

		//$this->load->model('homepage_model');
		
	}

}

/* End of file homepage_controller.php */
/* Location: ./application/controllers/homepage_controller.php */