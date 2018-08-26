<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolearn extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		$this->load->view('demolearn_view');
	}

}

/* End of file demolearn.php */
/* Location: ./application/controllers/demolearn.php */