# Write your MySQL query statement below
select user_id, COUNT(prompt) as prompt_count ,ROUND(AVG(tokens),2) as avg_tokens from prompts group by user_id 
having COUNT(prompt)>=3 AND MAX(tokens) > AVG(tokens)
order by avg_tokens desc, user_id asc