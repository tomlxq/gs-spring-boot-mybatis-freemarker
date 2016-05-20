jQuery.each( [ "delete", "put" ], function( i, method ) {
    // jQuery.get或jQuery.post为
    jQuery[ method ] = function( url, data, callback, type ) {

        // 模拟重载
        if ( jQuery.isFunction( data ) ) {
            type = type || callback;
            callback = data;
            data = undefined;
        }
        var options = {
            type: method,
            url: url,
            data: data,
            success: callback,
            dataType: type
        };
        if (method == "delete" || method == "put") {
            options = jQuery.extend(options, {
                contentType: "application/json",
                data: data == null ? {} : JSON.stringify(data)

            });
        }
        // 利用jQuery.ajax完成任务
        return jQuery.ajax(options);
    };
});