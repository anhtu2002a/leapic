<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Demolearn extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		//$this->load->view('demolearn_view');
		$this->load->model('demolearn_model');

		$volcabulary = $this->demolearn_model->getdatabase();
		$volcabulary = array('tuvung' => $volcabulary);

		// echo "<pre>";
		// var_dump($volcabulary);
		// echo "</pre>";
		$this->load->view('demolearn_view', $volcabulary, FALSE);
		
	}

}

/* End of file demolearn.php */
/* Location: ./application/controllers/demolearn.php */