<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
	
	class words {
    	private  $id;
        private  $learned;
        private  $TopicId;
        private  $wordType;
        private  $favorite;
        private  $name;
        private  $spell;
        private  $ex;
        private  $exMean;
        private  $Pic;

        public function __construct()
        {
            $this->id = $id;
            $this->wordType = $wordType;
            $this->TopicId = $TopicId;
            $this->learned = $learned;
            $this->favorite = $favorite;
            $this->name = $name;
            $this->spell = $spell;
            $this->ex = $ex;
            $this->exMean = $exMean;
            $this->Pic = $Pic;
        }


    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     *
     * @return self
     */
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getLearned()
    {
        return $this->learn;
    }

    /**
     * @param mixed $learn
     *
     * @return self
     */
    public function setLearned($learned)
    {
        $this->learned = $learned;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getTopicId()
    {
        return $this->TopicId;
    }

    /**
     * @param mixed $TopicId
     *
     * @return self
     */
    public function setTopicId($TopicId)
    {
        $this->TopicId = $TopicId;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getWordType()
    {
        return $this->wordType;
    }

    /**
     * @param mixed $wordType
     *
     * @return self
     */
    public function setWordType($wordType)
    {
        $this->wordType = $wordType;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getFavorite()
    {
        return $this->favorite;
    }

    /**
     * @param mixed $favorite
     *
     * @return self
     */
    public function setFavorite($favorite)
    {
        $this->favorite = $favorite;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * @param mixed $name
     *
     * @return self
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getSpell()
    {
        return $this->spell;
    }

    /**
     * @param mixed $spell
     *
     * @return self
     */
    public function setSpell($spell)
    {
        $this->spell = $spell;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getEx()
    {
        return $this->ex;
    }

    /**
     * @param mixed $ex
     *
     * @return self
     */
    public function setEx($ex)
    {
        $this->ex = $ex;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getExMean()
    {
        return $this->exMean;
    }

    /**
     * @param mixed $exMean
     *
     * @return self
     */
    public function setExMean($exMean)
    {
        $this->exMean = $exMean;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getPic()
    {
        return $this->Pic;
    }

    /**
     * @param mixed $Pic
     *
     * @return self
     */
    public function setPic($Pic)
    {
        $this->Pic = $Pic;

        return $this;
    }
}

