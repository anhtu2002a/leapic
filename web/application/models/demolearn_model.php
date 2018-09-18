<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolearn_model extends CI_Model {

	public $variable;
	

	public function __construct()
	{
		parent::__construct();
	}
	public function getdatabase()
	{
		$this->db->select('*');  //lay toan bo cot trong table Word
		$this->db->from('word');
		$this->db->join('topic', 'topic.ID = words.TopicId');
		$words = $this->db->get('');  //lay tu bang topic va luu vao bien words
		$words= $words->result_array(); //bien doi $words thanh 1 mang
		//$wordstest = array_slice($words, 0,1);
		return $words;
	}
}

/* End of file demolearn_model.php */
/* Location: ./application/models/demolearn_model.php */