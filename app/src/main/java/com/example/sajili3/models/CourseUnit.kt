package com.example.sajili3.models

data class CourseUnit(var UnitCode: String,
                      var UnitTitle: String,
                      var Lecturer: String,
                      var IsAvailable: Boolean,
                      var isSelected: Boolean = false)
