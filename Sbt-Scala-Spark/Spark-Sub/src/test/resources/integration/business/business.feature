Feature: Is the project working properly ?

  Scenario: Trying with one row
    Given Input CSV file located "src/test/resources/dataset/input/integration_dataset.csv" is:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |

    And Output CSV file located "src/test/resources/dataset/output/result.csv" is

    When I run spark job

    Then Output dataset located "/src/test/resources/dataset/output/result.csv" should contain:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |

  Scenario: Trying with 5 rows
    Given Input dataset located "/src/test/resources/dataset/input/integration_dataset.csv" is:
      | FIRST NAME | LAST NAME | GENDER | NATIONALITY | AGE | IS_ALIVE |
      | Daffy      | Duck      | Male   | USA         | 20  | yes      |
      | Bob        | Razowski  | Male   | USA         | 13  | yes      |
      | Minnie     | Mouse     | Female | USA         | 25  | yes      |
      | Donald     | Duck      | Male   | USA         | 27  | no       |
      | Daisy      | Duck      | Female | USA         | 28  | yes      |

    When I run spark job

    Then Output dataset should contain

  Scenario: Trying with 10 rows
    Given Input dataset located "/src/test/resources/dataset/input/integration_dataset.csv" is:
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

    When I run spark job

    Then Output dataset should contain
