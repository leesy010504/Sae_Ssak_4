DROP TABLE IF EXISTS rain_conditions;
CREATE TABLE rain_conditions (
  rain_condition_id INT AUTO_INCREMENT NOT NULL,
  crop_name VARCHAR(255) NOT NULL,
  max_rain INT NOT NULL,
  min_rain INT NOT NULL,
  PRIMARY KEY (rain_condition_id)
);

DROP TABLE IF EXISTS tem_conditions;
CREATE TABLE tem_conditions (
  tem_condition_id INT AUTO_INCREMENT NOT NULL,
  crop_name VARCHAR(255) NOT NULL,
  max_temper INT NOT NULL,
  min_temper INT NOT NULL,
  PRIMARY KEY (tem_condition_id)
);
