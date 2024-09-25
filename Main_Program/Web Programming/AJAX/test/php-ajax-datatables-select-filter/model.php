<?php

class Model
{
    private $server = "localhost";
    private $username = "root";
    private $password = "";
    private $db = "select_db";
    private $conn;

    public function __construct()
    {
        try {
            $this->conn = new mysqli($this->server, $this->username, $this->password, $this->db);
        } catch (\Throwable $th) {
            //throw $th;
            echo "Connection error " . $th->getMessage();
        }
    }

    // Fetch Standard

    public function fetch_std()
    {
        $data = [];

        $query = "SELECT DISTINCT `standard` FROM `student` ORDER BY `standard` ASC";
        if ($sql = $this->conn->query($query)) {
            while ($row = mysqli_fetch_assoc($sql)) {
                $data[] = $row;
            }
        }

        return $data;
    }

    // Fetch Result

    public function fetch_res()
    {
        $data = [];

        $query = "SELECT DISTINCT `result` FROM `student`";
        if ($sql = $this->conn->query($query)) {
            while ($row = mysqli_fetch_assoc($sql)) {
                $data[] = $row;
            }
        }

        return $data;
    }

    // Fetch Records

    public function fetch()
    {
        $data = [];

        $query = "SELECT * FROM student";
        if ($sql = $this->conn->query($query)) {
            while ($row = mysqli_fetch_assoc($sql)) {
                $data[] = $row;
            }
        }

        return $data;
    }

    // Filter Standard and Result

    public function fetch_filter($std, $res)
    {
        $data = [];

        $query = "SELECT * FROM student WHERE standard = '$std' AND result = '$res' ";
        if ($sql = $this->conn->query($query)) {
            while ($row = mysqli_fetch_assoc($sql)) {
                $data[] = $row;
            }
        }

        return $data;
    }

    // Filter Standard

    public function fetch_std_filter($std)
    {
        $data = [];

        $query = "SELECT * FROM student WHERE standard = '$std'";
        if ($sql = $this->conn->query($query)) {
            while ($row = mysqli_fetch_assoc($sql)) {
                $data[] = $row;
            }
        }

        return $data;
    }

    // Filter Result

    public function fetch_res_filter($res)
    {
        $data = [];

        $query = "SELECT * FROM student WHERE result = '$res'";
        if ($sql = $this->conn->query($query)) {
            while ($row = mysqli_fetch_assoc($sql)) {
                $data[] = $row;
            }
        }

        return $data;
    }
}