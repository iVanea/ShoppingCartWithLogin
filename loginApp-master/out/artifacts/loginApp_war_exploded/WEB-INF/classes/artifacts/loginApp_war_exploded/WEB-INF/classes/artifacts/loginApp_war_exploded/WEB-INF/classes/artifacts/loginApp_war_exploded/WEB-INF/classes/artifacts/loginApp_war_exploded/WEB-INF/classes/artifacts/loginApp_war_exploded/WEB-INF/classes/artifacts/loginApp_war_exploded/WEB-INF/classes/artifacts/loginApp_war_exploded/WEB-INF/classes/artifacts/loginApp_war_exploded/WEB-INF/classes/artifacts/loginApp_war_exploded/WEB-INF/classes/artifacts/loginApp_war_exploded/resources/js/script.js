$(function(){
	$('#btn_add').click(addProduct);
	
	function addProduct(){
		var productName = $('#product_name').val();
		var productPrice = $('#product_price').val();
		var url = "https://ss7.vzw.com/is/image/VerizonWireless/iPhoneX-Svr?$device-lg$";
		var product = {name:productName, price:productPrice, url:url};
		$.post('product',{product: JSON.stringify(product)}, processData, "json")
	}

	function processData(data){
		//data = JSON.parse(data);

        var img = $("<img />").attr('src', data.url)
            .on('load', function() {
                if (!this.complete || typeof this.naturalWidth == "undefined" || this.naturalWidth == 0) {
                    alert('broken image!');
                } else {
                    $("#something").append(img);
                }
            });
        
		var td0=$('<td>').text(data.id);
		var td1 = $('<td>').text(data.name);
		var td2 = $('<td>').text(data.price);



		var td3 = $('<td>').append(img);
		var tr = $('<tr>').append(td0).append(td1).append(td2).append(td3);
		$('#tbl_products>tbody').append(tr);
	}
})

