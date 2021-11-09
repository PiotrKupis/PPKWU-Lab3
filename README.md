# PPKWU-Lab3

Project responsible for performing operation on passed string and formating response in passed type.

ENDPOINT

Description: endpoint responsible for getting information about number of uppercase, lowercase, numbers, special characters and if contains its combination in passed string. 
Additionally it allows to indicate type of response (JSON, XML, CSV)  <br/><br/>
Path: analyze/{text}/{format} (GET)  
Params:  
&emsp;{text} - passed string  
&emsp;{format} - response format (JSON, XML, CSV)  
Return: object with data about passed string in passed format  
Error message on passing incorrect format: Incorrect format

EXAMPLES:

input for JSON reponse:  
/analyze/aaAA12@$/JSON  

Response:  
```
{
    "uppercase": 2,
    "lowercase": 2,
    "numbers": 2,
    "specialChars": 2,
    "combination": true
}  
```

input for XML reponse:  
/analyze/aaAA12@$/XML  

Response:  
```
<analyze>
    <uppercase>2</uppercase>
    <lowercase>2</lowercase>
    <specialChars>2</specialChars>
    <numbers>2</numbers>
    <combination>true</combination>
</analyze>
```

input for CSV reponse:  
/analyze/aaAA12@$/CSV  

Response:  
```
uppercase,lowercase,number,specialChars,combination
2,2,2,2,true
```
