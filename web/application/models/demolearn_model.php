<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolearn_model extends CI_Model {

	public $variable;

	public function __construct()
	{
		parent::__construct();
		
	}
	public function getdatabase()
	{
		$this->db->select('*');  //lay cac cot Word_Name,Word_Pic,Word_Ex tu Table words
		$this->db->from('words');
		$this->db->join('topic', 'topic.ID = words.TopicId');
		$words = $this->db->get('');  //lay tu bang topic va luu vao bien words

		$words= $words->result_array(); //bien doi $words thanh 1 mang
		return $words;
		$results = array();
	}
}

/* End of file demolearn_model.php */
/* Location: ./application/models/demolearn_model.php */