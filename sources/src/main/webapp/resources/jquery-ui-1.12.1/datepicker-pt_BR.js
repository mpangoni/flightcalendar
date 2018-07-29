/* French initialisation for the jQuery UI date picker plugin. */
/* Written by Keith Wood (kbwood{at}iinet.com.au),
			  Stéphane Nahmani (sholby@sholby.net),
			  Stéphane Raimbault <stephane.raimbault@gmail.com> */
              ( function( factory ) {
                if ( typeof define === "function" && define.amd ) {
            
                    // AMD. Register as an anonymous module.
                    define( [ "../widgets/datepicker" ], factory );
                } else {
            
                    // Browser globals
                    factory( jQuery.datepicker );
                }
            }( function( datepicker ) {
            
            datepicker.regional.fr = {
                closeText: 'Fechar',
                prevText: '&#x3c;Anterior',
                nextText: '&#x3c;Anterior',
                currentText: "Hoje",
                monthNames: ['Janeiro','Fevereiro','Mar&ccedil;o','Abril','Maio','Junho',
                    'Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
                monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun',
                    'Jul','Ago','Set','Out','Nov','Dez'],
                dayNames: ['Domingo','Segunda-feira','Ter&ccedil;a-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sabado'],
                dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
                dayNamesMin: [ "D","S","T","Q","Q","S","S" ],
                weekHeader: "Sem.",
                dateFormat: "dd/mm/yy",
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: "" };
            datepicker.setDefaults( datepicker.regional.fr );
            
            return datepicker.regional.fr;
            
            } ) );