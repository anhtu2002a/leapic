<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolistlearn_model extends CI_Model {

	public $variable;

	public function __construct()
	{
		parent::__construct();
		
	}
	public function getdatabase()
	{
		$this->db->select('ID,Name, Icon2, Icon1');  //lay het du lieu
		$category = $this->db->get('topic');  //lay tu bang topic va luu vao bien category

		// dua ket qua thanh 1 mang du lieu
		$category= $category->result_array(); //bien doi $category thanh 1 mang
		return $category;
		

		// echo "<pre>";
		// var_dump($category);
		// echo "</pre>";
	}

}

/* End of file demolistlearn_model.php */
/* Location: ./application/models/demolistlearn_model.php */