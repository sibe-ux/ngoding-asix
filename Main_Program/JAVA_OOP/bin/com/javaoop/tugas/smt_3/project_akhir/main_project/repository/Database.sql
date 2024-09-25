select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas, t.urutan, t.id_mapel, t.category, s.nama
from status_tugas as st
join tugas t on st.id_tugas = t.id_tugas join siswa s on t.category = s.category  
where s.category = '11-IPA-1' and t.id_mapel = 'MTK-01' 

select count(*) as baris from tugas where id_mapel = 'MTK-01' and category = '11-IPA-1'

update status_tugas set id_tugas='T11', nis='1001', is_kerjakan='90' where id_tugas='T-1'

SELECT m.nama,t.nama_tugas,t.urutan 
FROM mapel m 
JOIN tugas t ON m.id_mapel = t.id_mapel 
JOIN status_tugas st ON t.id_tugas = st.id_tugas 
where st.nis = '1001' and st.is_kerjakan = 'false'

select s.*, st.*, t.*, m.*
from status_tugas as st
join tugas as t on st.id_tugas = t.id_tugas
join mapel as m on t.id_mapel = m.id_mapel
join siswa as s on st.nis = cast(s.nis as varchar(15))
where s.nis = '1001' order by m.nama asc

select st.is_kerjakan, t.urutan, m.nama  
from status_tugas as st
join tugas as t on st.id_tugas = t.id_tugas
join mapel as m on m.id_mapel = t.id_mapel
where st.is_kerjakan != 'false' and st.is_kerjakan != 'true' and st.nis='1003' and t.urutan=1 and m.id_mapel = 'MTK-01'

select avg(cast(st.is_kerjakan as Integer))
from status_tugas as st
join tugas as t on st.id_tugas = t.id_tugas
join mapel as m on m.id_mapel = t.id_mapel
where st.is_kerjakan != 'false' and st.is_kerjakan != 'true' and st.nis='1001' and m.id_mapel = 'PKN-17'

select AVG(cast(is_kerjakan as Integer)) from status_tugas where is_kerjakan != 'false' and is_kerjakan != 'true' 

select s.nama,s.category, kl.tingkat, kl.jurusan
from siswa as s
join kelas_object as kl on s.category = kl.category


select avg(cast(st.is_kerjakan as integer)) as avg, sum(cast(st.is_kerjakan as integer)) as sum
, s.nis, s.nama, kl.tingkat, kl.jurusan, kl.category
from status_tugas as st
join siswa as s on st.nis = cast(s.nis as varchar(5))
join kelas_object as kl on s.category = kl.category 
where st.is_kerjakan != 'false' and st.is_kerjakan != 'true'
group by s.nis, s.nama, kl.tingkat, kl.jurusan, kl.category order by avg desc
 
select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,
              	t.urutan, t.id_mapel, t.category
                from status_tugas as st
                join tugas as t on st.id_tugas = t.id_tugas 
                where t.category = '10-IPS-1' and t.id_mapel='PAI-05'
                and st.is_kerjakan = 'false' and t.urutan = 1
				
select st.id_tugas, t.nama_tugas,
            t.urutan, t.id_mapel, t.category
            from tugas as t
            join status_tugas as st on st.id_tugas = t.id_tugas 
            where t.category = '10-IPS-1' and t.id_mapel='PAI-05'
			
SELECT * from tugas where category = '10-IPS-1' and id_mapel = 'PAI-05'
			
select count(*) as jumlah from tugas where id_mapel='PAI-05' and category='10-IPS-1'

-- UNTUK JOIN, HARUS PK DAN FK, GA BOLEH FK DAN FK
select st.id_tugas, st.nis, st.is_kerjakan, t.nama_tugas,
             t.urutan, t.id_mapel, t.category, s.nama 
            from status_tugas as st
            join tugas t on st.id_tugas = t.id_tugas 
			join siswa s on st.nis = cast(s.nis as varchar(15)) 
            where t.category = '10-IPS-1' and t.id_mapel='PAI-05' and urutan = 1