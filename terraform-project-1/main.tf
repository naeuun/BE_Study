terraform {
  // 자바의 import 와 비슷함
  // aws 라이브러리 불러옴
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.0"
    }
  }
}

# Configure the AWS Provider
provider "aws" {
  region = "ap-northeast-2"
}

resource "aws_vpc" "example_1" { // 변수명은 중복 불가
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "example-1"
  }
}

resource "aws_vpc" "example_2" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "example-2"
  }
}

resource "aws_vpc" "example_3" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "example-3"
  }
}