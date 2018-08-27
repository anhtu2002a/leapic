<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolistlearn extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		$this->load->view('demolistlearn_view');		
	}

}

/* End of file demolistlearn.php */
/* Location: ./application/controllers/demolistlearn.php */