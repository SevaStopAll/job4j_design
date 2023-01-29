select avg(price) from devices;

select devices_people.people_id, avg(devices.price)
from devices_people
join devices
on devices.id = devices_people.device_id
group by devices_people.people_id


select devices_people.people_id, avg(devices.price)
from devices_people
join devices
on devices.id = devices_people.device_id
group by devices_people.people_id
having avg(devices.price) > 5000.00;