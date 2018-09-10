<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Demogame extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
	}

	public function index()
	{
		$this->load->view('demogame_view');
	}
}

/* End of file demogame_controller.php */
/* Location: ./application/controllers/demogame_controller.php */