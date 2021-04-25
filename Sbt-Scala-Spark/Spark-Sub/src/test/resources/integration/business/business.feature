Feature: Is the project working properly ?

  Scenario: Trying with one row
    Given Input CSV file located "src/test/resources/integration/dataset/input/integration_dataset.csv" is:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |

    And Output CSV file located "src/test/resources/integration/dataset/output/result_with_one_row" is

    When I run spark job

    Then Output dataset located "src/test/resources/integration/dataset/output/result_with_one_row" should contain:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |

  Scenario: Trying with 5 rows
    Given Input CSV file located "src/test/resources/integration/dataset/input/integration_dataset.csv" is:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |
      | Bob        | Razowski  | Male   | USA         | 13  | yes      |
      | Minnie     | Mouse     | Female | USA         | 25  | yes      |
      | Donald     | Duck      | Male   | USA         | 27  | no       |
      | Daisy      | Duck      | Female | USA         | 28  | yes      |

    And Output CSV file located "src/test/resources/integration/dataset/output/result_with_five_row" is

    When I run spark job

    Then Output dataset located "src/test/resources/integration/dataset/output/result_with_five_row" should contain:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |
      | Minnie     | Mouse     | Female | USA         | 25  | yes      |
      | Donald     | Duck      | Male   | USA         | 27  | no       |
      | Daisy      | Duck      | Female | USA         | 28  | yes      |

  Scenario: Trying with 10 rows
    Given Input CSV file located "src/test/resources/integration/dataset/input/integration_dataset.csv" is:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |
      | Homer      | Simpson   | Male   | USA         | 37  | yes      |
      | Blanche    | Neige     | Female | UK          | 23  | No       |
      | Bob        | Razowski  | Male   | USA         | 13  | yes      |
      | Minnie     | Mouse     | Female | USA         | 25  | yes      |
      | Marge      | Simpson   | Female | USA         | 36  | yes      |
      | Donald     | Duck      | Male   | USA         | 27  | no       |
      | Jessie     | James     | Female | UK          | 22  | yes      |
      | Daisy      | Duck      | Female | USA         | 28  | yes      |
      | Lisa       | Simpson   | Female | USA         | 12  | yes      |

    And Output CSV file located "src/test/resources/integration/dataset/output/result_with_ten_row" is

    When I run spark job

    Then Output dataset located "src/test/resources/integration/dataset/output/result_with_ten_row" should contain:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |
      | Homer      | Simpson   | Male   | USA         | 37  | yes      |
      | Blanche    | Neige     | Female | UK          | 23  | No       |
      | Minnie     | Mouse     | Female | USA         | 25  | yes      |
      | Marge      | Simpson   | Female | USA         | 36  | yes      |
      | Donald     | Duck      | Male   | USA         | 27  | no       |
      | Jessie     | James     | Female | UK          | 22  | yes      |
      | Daisy      | Duck      | Female | USA         | 28  | yes      |
