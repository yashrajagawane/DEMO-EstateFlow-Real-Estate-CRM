document.addEventListener('DOMContentLoaded',()=>{
  const toggle=document.getElementById('menuToggle'), sidebar=document.getElementById('sidebar');
  if(toggle&&sidebar) toggle.addEventListener('click',()=>sidebar.classList.toggle('open'));
  const theme=document.getElementById('themeToggle');
  if(theme) theme.addEventListener('click',()=>{document.body.classList.toggle('dark');localStorage.setItem('ef-dark',document.body.classList.contains('dark'));});
  if(localStorage.getItem('ef-dark')==='true') document.body.classList.add('dark');
  const search=document.getElementById('tableSearch');
  if(search) search.addEventListener('input',()=>{const q=search.value.toLowerCase();document.querySelectorAll('.crm-table tbody tr').forEach(row=>row.style.display=row.innerText.toLowerCase().includes(q)?'':'none');});
  setTimeout(()=>document.querySelectorAll('.toast-message').forEach(el=>{el.style.transition='opacity .4s';el.style.opacity='0';setTimeout(()=>el.remove(),450)}),3500);
});
