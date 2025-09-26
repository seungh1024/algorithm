-- 코드를 입력하세요
SELECT CAR_ID, round(sum(datediff(end_date, start_date)+1)/count(car_id),1) as AVERAGE_DURATION
from car_rental_company_rental_history
group by car_id
Having AVERAGE_DURATION >=7
order by AVERAGE_DURATION DESC, CAR_ID DESC;


# SELECT CAR_ID, datediff(end_date,start_date)
# from car_rental_company_rental_history
# # group by car_id
# order by car_id;