/**
 * 
 */

$(document).ready(function(){
	
	$('.user1list1').click(function(){
		$.ajax({
			url:'/Ch09/user1',
			method:'GET',
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
	$('.user1list2').click(function(){
		
		let uid = 'a104';
		
		$.ajax({
			url:'/Ch09/user1/'+uid,
			method:'GET',
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
	$('.user1register').click(function(){
		
		let jsonData = {
			"uid":"a101",
			"name":"홍길동",
			"hp":"010-1234-1101",
			"age":19
		};
		
		$.ajax({
			url:'/Ch09/user1/',
			method:'POST',
			data:jsonData,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
		
	});
	
	$('.user1modify').click(function(){
	
		let jsonData = {
				"uid":"a101",
				"name":"홍길동",
				"hp":"010-1234-1101",
				"age":29
			};
		
		$.ajax({
			url:'/Ch09/user1/',
			method:'PUT',
			data:jsonData,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	$('.user1delete').click(function(){
		
		let uid = 'a104';
		
		$.ajax({
			url:'/Ch09/user1/'+uid,
			method:'DELETE',
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
});