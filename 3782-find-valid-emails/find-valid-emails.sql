select user_id, email
from Users
where email like '%.com'
  and email not like '%@%@%'        
  and email like '%@%'           
  and  email ~ '^[a-zA-Z0-9_]+@[a-zA-Z]+\.com' order by user_id