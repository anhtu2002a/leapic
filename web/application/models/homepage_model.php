<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class homepage_model extends CI_Model {

	public $variable;

	public function __construct()
	{
		parent::__construct();
		
	}
	public function getdatabase()
	{
		$this->db->select('img_link'); //lay het du lieu
		$image = $this->db->get('webimage'); //lay du lieu tu bang webimage

		var_dump($ketqua);
	}

}

/* End of file homepage_model.php */
/* Location: ./application/models/homepage_model.php */