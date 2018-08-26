<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demogame_model extends CI_Model {

	public $variable;

	public function __construct()
	{
		parent::__construct();
		
	}
	public function getdatabase()
	{
		$this->db->select('*'); //lay het du lieu 
		$ketqua = $this->db->get('webimage'); //lay tu bang webimage luu vao mang ket qua
		$ketqua = $ketqua->result_array();
		
		return $ketqua;
		//var_dump($ketqua); //in ra ket qua xem thu

	}
}

/* End of file demogame_model.php */
/* Location: ./application/models/demogame_model.php */