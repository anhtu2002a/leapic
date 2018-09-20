<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class demolistlearn_model extends CI_Model {

	public $variable;

	public function __construct()
	{
		parent::__construct();

		
	}
	public function loadCategory()
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
	public function insertWords($Word, $WordType, $Spell, $Mean, $Ex, $ExMean, $Pic, $TopicId)
	{
		$Word = array(
	    	'Word' => $Word,
			'WordType' => $WordType,
			'Spell' => $Spell,
			'Mean' => $Mean,
			'Ex' => $Ex,
			'ExMean' => $ExMean,
			'Pic' => $Pic,
			'TopicId' => $TopicId,
    	);
		$result = $this->db->insert('words', $Word);
		return $result;
	}
	public function getWordsByID($ID)
	{
		$this->db->select('word.Id,word.Name,word.TopicId,word.WordType,word.Spell,word.Mean,word.Pic,word.Learned');
		$this->db->where('TopicId', $ID);
		$this->db->from('word');
		$this->db->join('topic', 'topic.ID = word.TopicId');
		$Words= $this->db->get('');  //lay tu bang words va luu vao bien words
		$Words= $Words->result(); //bien doi $words thanh 1 mang objec
		return $Words;
	}
	public function markLearnedWord()
	{
		$Id = $this->input->post('word_Id');
		$Learned = $this->input->post('word_learned');
		$this->db->set('learned',$Learned);
		$this->db->where('Id', $Id);
		$result=$this->db->update('word');
	}
}

/* End of file demolistlearn_model.php */
/* Location: ./application/models/demolistlearn_model.php */