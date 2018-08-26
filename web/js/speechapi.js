                      var final_transcript = ' ';
                      var recognizing = false;

                    if ('webkitSpeechRecognition' in window) {

                      var recognition = new webkitSpeechRecognition();

                      recognition.continuous = false;
                      recognition.interimResults = true;
                      
                      recognition.onstart = function() {
                        recognizing = true;
                        $("#start_button").attr('src','/WebAppLeng/img/game-img/microphone2.png');
                        $("#recording").text('Đang nghe nè!').show().fadeOut(4000);
                        $("#question").hide();
                        // Jquery kiem tra ket qua
                        setTimeout(function(handler){
                          if($("#final_span").text() == "Hello"){
                            $("#kq").attr('src','/WebAppLeng/img/game-img/Rig-img.png');
                          }else{
                            $("#kq").attr('src','/WebAppLeng/img/game-img/Wro-img.png');
                          }
                        },4000);
                        $("#kq").attr('src','/WebAppLeng/img/game-img/Ans-img.png');

                      };

                      recognition.onerror = function(event) {
                        console.log(event.error);
                      };

                      recognition.onend = function() {
                        recognizing = false;
                        $("#start_button").attr('src','/WebAppLeng/img/game-img/microphone1.png');
                      };

                      recognition.onresult = function(event) {
                        var interim_transcript = '';
                        for (var i = event.resultIndex; i < event.results.length; ++i) {
                          if (event.results[i].isFinal) {
                            final_transcript += event.results[i][0].transcript;
                          } else {
                            interim_transcript += event.results[i][0].transcript;
                          }
                        }
                        final_transcript = capitalize(final_transcript);
                        final_span.innerHTML = linebreak(final_transcript);
                        interim_span.innerHTML = linebreak(interim_transcript);
                        
                      };
                    }

                    var two_line = /\n\n/g;
                    var one_line = /\n/g;
                    function linebreak(s) {
                      return s.replace(two_line, '<p></p>').replace(one_line, '<br>');
                    }

                    function capitalize(s) {
                      return s.replace(s.substr(0,1), function(m) { return m.toUpperCase(); });
                    }

                    function startDictation(event) {
                      if (recognizing) {
                        recognition.stop();
                        return;
                      }
                      final_transcript = '';
                      recognition.lang = 'en-US';
                      recognition.start();
                      final_span.innerHTML = '';
                      interim_span.innerHTML = '';

                    }

                    
                                        
