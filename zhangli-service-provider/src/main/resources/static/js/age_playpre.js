function __age_cb_getplay_url() {
    const _url = window.location.href;
    const _rand = Math.random();
    var _getplay_url = (_url.replace(/.*\/play\/(\d+?)\?playid=(\d+)_(\d+).*/, '/_getplay?aid=$1&playindex=$2&epindex=$3') + '&r=' + _rand);
    var re_resl = _getplay_url.match(/[&?]+epindex=(\d+)/);
    const hf_epi = ('' + FEI2(re_resl[1]));
    const t_epindex_ = 'epindex=';
    _getplay_url = _getplay_url.replace(t_epindex_ + re_resl[1], t_epindex_ + hf_epi);
    return _getplay_url
}

function __age_play_ep_scroll() {
    const _href_url = window.location.href;
    const _refresl = _href_url.match(/\/play\/(\d+?)\?playid=(\d+)_(\d+)/);
    const _iPlay = (_refresl ? Number(_refresl[2]) - 1 : Number($('#DEF_PLAYINDEX').text()));
    const _iEP = (_refresl ? Number(_refresl[3]) - 1 : 0);
    const _t_sel_movurl = '.tabs .main0 .movurl:nth-child(' + (_iPlay + 1) + ')';
    const _sel_lis = $(_t_sel_movurl + ' ul li');
    const _ep0_pos = _sel_lis[0].offsetTop;
    const _ep_pos = _sel_lis[_iEP].offsetTop;
    $(_t_sel_movurl + ' ul').scrollTop(_ep_pos - _ep0_pos);
    if (_refresl) {
        const _t_sel_ep = _t_sel_movurl + ' ul li:nth-child(' + (_iEP + 1) + ')';
        const _sel_a = $(_t_sel_ep + ' a');
        _sel_a.css('border', '1px solid #E00');
        _sel_a.css('color', '#E00')
    } else {
        $(document).ready(function () {
            $('#ageframediv').css('display', 'none')
        })
    }
}

const __age_g_exXP = [''];
var __age_g_isfullscn = false;
var __age_g_new_playleft_id = null;
var __age_margin_bak = '';

function __age_playfull_set(_in_id, _in_title_on, _in_exXP) {
    if (!navigator.userAgent.match(/(iPhone|iPod|Android|mobile|blackberry|webos|incognito|webmate|bada|nokia|lg|ucweb|skyfire)/i)) {
        $('#' + _in_id).append('<a class="fullscn' + _in_exXP + '">' + _in_title_on + '</a>');
        if (!__age_g_isfullscn || !_in_exXP) {
            $((".fullscn" + _in_exXP)).show()
        }
        $('#' + _in_id).mouseover(function () {
            if (!__age_g_isfullscn || !_in_exXP) {
                $((".fullscn" + _in_exXP)).show()
            }
        }).mouseout(function () {
            $((".fullscn" + _in_exXP)).hide()
        });
        $((".fullscn" + _in_exXP)).click(function () {
            if (!__age_g_isfullscn) {
                $((".fullscn" + '')).html('还原窗口');
                const _new_ID = ("fullplayleft" + _in_exXP);
                $('#' + _in_id + ' iframe').css('width', '100%');
                $('#' + _in_id + ' iframe').css('height', '100%');
                __age_margin_bak = $('#' + _in_id + ' iframe').css('margin');
                $('#' + _in_id + ' iframe').css('margin', '0px');
                $('#' + _in_id).attr("id", _new_ID);
                __age_g_new_playleft_id = _new_ID;
                __age_g_isfullscn = true
            } else {
                $((".fullscn" + '')).html(_in_title_on);
                $('#' + _in_id + ' iframe').css('margin', __age_margin_bak);
                $(('#' + __age_g_new_playleft_id)).attr("id", _in_id);
                __age_g_isfullscn = false
            }
        })
    }
}

function __age_exp_playfull_set(_in_id) {
    for (var i = 0; i < __age_g_exXP.length; i++) {
        const p1 = (__age_g_exXP[i] ? ('网页' + __age_g_exXP[i] + 'P') : '网页全屏');
        const p2 = (__age_g_exXP[i] ? ('-' + __age_g_exXP[i] + 'p') : '');
        __age_playfull_set(_in_id, p1, p2)
    }
}

function __on_sendcomment() {
    $.get("/" + "p" + "c" + "k", function (data, status) {
    });
    for (d = new Date().getTime(); (d + 500) > (new Date().getTime());) {
    }
    ;var username = __getCookie_v3('username');
    if (!username) {
        alert("登陆功能已修复，请登陆后发言")
    }
    ;var encode_version = 'sojson.v5', yqpcz = '__0x6d4a1',
        __0x6d4a1 = ['wq4mw7/CmF4=', 'w6XDrMOmwprCgg==', 'eRfDo8OoZQ==', 'IUnCmSzDgyfDjw==', 'S0pEJ8KxUMOSwqlq', 'asOow5tBwqk=', '5Lqc6ICk5Yi16ZuCw7A4wqEAwqHCisKHwr0/', 'TjpSwqZ3WMOmG8Oz', 'MhvDm8OOwqk=', 'XsKOwrAgwrFzwoU=', 'UyHCmcOyREsv', 'N2DDnXUC', 'BcOIwowrdgc=', 'GcOwNxbDqg==', 'JcKMw4ZORw==', 'Jm/ChVfDhw==', 'w7U3w4PCksKm', 'w7jDnHDCpcOF', 'wrgOw5PDlcO7', 'w4HDkMODYcK/D8O0PMKjShFZcw==', 'F8KFT8Ktwp3Ckw/CqXI=', 'M8O0dUFY', 'e1zDtMOGZg==', 'w6LChsKLCBo=', 'EMKJXSbDjQ==', 'T8KPWMK2wp3ChA==', 'wpRjw5BEZQ==', 'JHsWwq3DoQ==', 'HsKKUAvDqw==', 'wopnw5BzZA3DgQ==', 'wqAkw5PCpmw=', 'w68MBSvDow==', 'MljDsVQq', 'FMKIw6xETQ=='];
    (function (_0x3aee46, _0x59ba69) {
        var _0x3ea520 = function (_0x1dd9c6) {
            while (--_0x1dd9c6) {
                _0x3aee46['push'](_0x3aee46['shift']())
            }
        };
        _0x3ea520(++_0x59ba69)
    }(__0x6d4a1, 0x15b));
    var _0x15f5 = function (_0x36bc78, _0xbd2420) {
        _0x36bc78 = _0x36bc78 - 0x0;
        var _0xfd0a5f = __0x6d4a1[_0x36bc78];
        if (_0x15f5['initialized'] === undefined) {
            (function () {
                var _0x4b7bb1 = typeof window !== 'undefined' ? window : typeof process === 'object' && typeof require === 'function' && typeof global === 'object' ? global : this;
                var _0x531bb8 = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
                _0x4b7bb1['atob'] || (_0x4b7bb1['atob'] = function (_0x1870ad) {
                    var _0x576c80 = String(_0x1870ad)['replace'](/=+$/, '');
                    for (var _0x44d56e = 0x0, _0x1a3ebb, _0x42d2dc, _0x1cf4b1 = 0x0, _0x2af9b7 = ''; _0x42d2dc = _0x576c80['charAt'](_0x1cf4b1++); ~_0x42d2dc && (_0x1a3ebb = _0x44d56e % 0x4 ? _0x1a3ebb * 0x40 + _0x42d2dc : _0x42d2dc, _0x44d56e++ % 0x4) ? _0x2af9b7 += String['fromCharCode'](0xff & _0x1a3ebb >> (-0x2 * _0x44d56e & 0x6)) : 0x0) {
                        _0x42d2dc = _0x531bb8['indexOf'](_0x42d2dc)
                    }
                    return _0x2af9b7
                })
            }());
            var _0x1897b8 = function (_0x3c0b9b, _0x2579f3) {
                var _0x5a0327 = [], _0x330679 = 0x0, _0x12b19f, _0x3ebfbf = '', _0x20630f = '';
                _0x3c0b9b = atob(_0x3c0b9b);
                for (var _0x514228 = 0x0, _0x4f7f74 = _0x3c0b9b['length']; _0x514228 < _0x4f7f74; _0x514228++) {
                    _0x20630f += '%' + ('00' + _0x3c0b9b['charCodeAt'](_0x514228)['toString'](0x10))['slice'](-0x2)
                }
                _0x3c0b9b = decodeURIComponent(_0x20630f);
                for (var _0x53cc80 = 0x0; _0x53cc80 < 0x100; _0x53cc80++) {
                    _0x5a0327[_0x53cc80] = _0x53cc80
                }
                for (_0x53cc80 = 0x0; _0x53cc80 < 0x100; _0x53cc80++) {
                    _0x330679 = (_0x330679 + _0x5a0327[_0x53cc80] + _0x2579f3['charCodeAt'](_0x53cc80 % _0x2579f3['length'])) % 0x100;
                    _0x12b19f = _0x5a0327[_0x53cc80];
                    _0x5a0327[_0x53cc80] = _0x5a0327[_0x330679];
                    _0x5a0327[_0x330679] = _0x12b19f
                }
                _0x53cc80 = 0x0;
                _0x330679 = 0x0;
                for (var _0x25c772 = 0x0; _0x25c772 < _0x3c0b9b['length']; _0x25c772++) {
                    _0x53cc80 = (_0x53cc80 + 0x1) % 0x100;
                    _0x330679 = (_0x330679 + _0x5a0327[_0x53cc80]) % 0x100;
                    _0x12b19f = _0x5a0327[_0x53cc80];
                    _0x5a0327[_0x53cc80] = _0x5a0327[_0x330679];
                    _0x5a0327[_0x330679] = _0x12b19f;
                    _0x3ebfbf += String['fromCharCode'](_0x3c0b9b['charCodeAt'](_0x25c772) ^ _0x5a0327[(_0x5a0327[_0x53cc80] + _0x5a0327[_0x330679]) % 0x100])
                }
                return _0x3ebfbf
            };
            _0x15f5['rc4'] = _0x1897b8;
            _0x15f5['data'] = {};
            _0x15f5['initialized'] = !![]
        }
        var _0x597ef6 = _0x15f5['data'][_0x36bc78];
        if (_0x597ef6 === undefined) {
            if (_0x15f5['once'] === undefined) {
                _0x15f5['once'] = !![]
            }
            _0xfd0a5f = _0x15f5['rc4'](_0xfd0a5f, _0xbd2420);
            _0x15f5['data'][_0x36bc78] = _0xfd0a5f
        } else {
            _0xfd0a5f = _0x597ef6
        }
        return _0xfd0a5f
    };
    if (!![]) {
        var _0x36d031 = _0x15f5('0x0', 'CuZW')[_0x15f5('0x1', '^Ou5')]('|'), _0x5a77e0 = 0x0;
        while (!![]) {
            switch (_0x36d031[_0x5a77e0++]) {
                case'0':
                    f2 = function (_0x369589, _0x22305e) {
                        var _0x3df411 = {
                            'DUWem': function _0x172fb9(_0x5ec61c, _0x564208) {
                                return _0x5ec61c + _0x564208
                            }, 'chgqL': function _0xdabcda(_0x221552, _0x9f16bb) {
                                return _0x221552 * _0x9f16bb
                            }, 'ueYPD': function _0x42de89(_0x168663, _0x45775b) {
                                return _0x168663 + _0x45775b
                            }, 'FyVON': function _0x132543(_0x14cf95, _0x5f0613) {
                                return _0x14cf95 + _0x5f0613
                            }, 'rImkg': function _0x3ee8de(_0x50917a, _0x5aa05b) {
                                return _0x50917a + _0x5aa05b
                            }, 'EhXgt': ';expires=', 'eglgt': _0x15f5('0x2', 'y4Vs')
                        };
                        var _0x355c8f = 0x1e;
                        var _0x36f590 = new Date();
                        _0x36f590['setTime'](_0x3df411['DUWem'](_0x36f590[_0x15f5('0x3', 'wmgi')](), _0x3df411[_0x15f5('0x4', 'Put*')](_0x3df411['chgqL'](_0x3df411['chgqL'](_0x355c8f, 0x18), 0x3c) * 0x3c, 0x3e8)));
                        document[_0x15f5('0x5', '(m&I')] = _0x3df411['DUWem'](_0x3df411[_0x15f5('0x6', 'PIK)')](_0x3df411['FyVON'](_0x3df411['rImkg'](_0x3df411[_0x15f5('0x7', 'MDzc')](_0x369589, '='), escape(_0x22305e)), _0x3df411[_0x15f5('0x8', 'bDPL')]), _0x36f590['toGMTString']()), _0x3df411[_0x15f5('0x9', 'Doro')])
                    };
                    continue;
                case'1':
                    t1 = Math[_0x15f5('0xa', 'Q5gT')](Number(f('t1')) / 0x3e8) >> 0x5;
                    continue;
                case'2':
                    f = function (_0x30755b) {
                        var _0x2061a3 = {
                            'JwcjB': function _0x4d63cc(_0x53138c, _0x57679f) {
                                return _0x53138c + _0x57679f
                            },
                            'zWwUP': _0x15f5('0xb', 'Doro'),
                            'zMNwJ': _0x15f5('0xc', 'mu(g'),
                            'QLLCz': function _0xcf9e5b(_0x22b423, _0x4bb2df) {
                                return _0x22b423(_0x4bb2df)
                            },
                            'tNCZl': 'BSp',
                            'fPKPd': function _0x1e8a5f(_0x1b5aa9, _0x4db818) {
                                return _0x1b5aa9 + _0x4db818
                            },
                            'BbKyG': function _0x1758f2(_0x471863, _0x128f5e) {
                                return _0x471863 * _0x128f5e
                            },
                            'xIvIx': function _0x25258e(_0xf7b32b, _0x717bc1) {
                                return _0xf7b32b * _0x717bc1
                            },
                            'CMGam': function _0x5cb526(_0x32dc57, _0x589dad) {
                                return _0x32dc57 + _0x589dad
                            },
                            'hRgnV': function _0x30a4e5(_0x401fb4, _0x49024c) {
                                return _0x401fb4 + _0x49024c
                            },
                            'QNctg': _0x15f5('0xd', 'KvKZ')
                        };
                        var _0x583897,
                            _0x3a66ce = new RegExp(_0x2061a3[_0x15f5('0xe', 'Ox#l')](_0x2061a3[_0x15f5('0xf', 'v78#')](_0x2061a3[_0x15f5('0x10', '7jQL')], _0x30755b), _0x2061a3[_0x15f5('0x11', '6O7p')]));
                        if (_0x583897 = document[_0x15f5('0x12', 'KvKZ')][_0x15f5('0x13', 'Z@&Q')](_0x3a66ce)) {
                            return _0x2061a3[_0x15f5('0x14', 'g#CQ')](unescape, _0x583897[0x2])
                        } else {
                            if (_0x2061a3['tNCZl'] !== _0x2061a3[_0x15f5('0x15', '6O7p')]) {
                                var _0x2856c4 = 0x1e;
                                var _0x412bd3 = new Date();
                                _0x412bd3[_0x15f5('0x16', 'Z@&Q')](_0x2061a3[_0x15f5('0x17', '0USv')](_0x412bd3['getTime'](), _0x2061a3['BbKyG'](_0x2061a3[_0x15f5('0x18', 'x]l]')](_0x2856c4, 0x18) * 0x3c * 0x3c, 0x3e8)));
                                document['cookie'] = _0x2061a3[_0x15f5('0x19', 'Put*')](_0x2061a3['fPKPd'](_0x2061a3[_0x15f5('0x1a', 'MDzc')](_0x2061a3[_0x15f5('0x1b', '0USv')](_0x30755b + '=', _0x2061a3[_0x15f5('0x1c', 'd$Fs')](escape, value)), _0x2061a3[_0x15f5('0x1d', 's1ve')]), _0x412bd3['toGMTString']()), ';path=/')
                            } else {
                                return null
                            }
                        }
                    };
                    continue;
                case'3':
                    f2('t2', new Date()[_0x15f5('0x1e', '9k4F')]());
                    continue;
                case'4':
                    f2('k2', (t1 * (t1 % 0x1000) + 0x99d6) * (t1 % 0x1000) + t1);
                    continue
            }
            break
        }
    }
    ;
    if (!(typeof encode_version !== 'undefined' && encode_version === _0x15f5('0x1f', 'wZ(I'))) {
        window[_0x15f5('0x20', 'KbZ5')](_0x15f5('0x21', 'YAu4'))
    }
    ;encode_version = 'sojson.v5';
    var encode_version = 'sojson.v5', woaew = '__0x6d4a2',
        __0x6d4a2 = ['w4TCkxtLwofCuBE=', 'YsKYwok/w5M=', 'DWwZJDPDksOi', 'wocjwrkSXQ==', 'XG5tw6Y2', 'OMOpSErDhw==', 'AA7DksO/w4gM', 'w5prw6vCrFI=', 'w7U3L8K1bQ==', 'Z8K5wrJIwrE=', 'L8OKZcKaGcOoTcOUwqIFYw==', 'YCPDs1bDrQPDvg==', 'dcOrVsOlwoA=', 'OcORb2nDtg==', 'FcKQdxtY', 'dsKSQz8V', 'McKZVzd2Xg==', 'VyEpUy4=', 'ASUlQC97HGdz', 'wqzDryzCjMKSWAE='];
    (function (_0x57c88f, _0x2383d8) {
        var _0x4b2391 = function (_0x58c926) {
            while (--_0x58c926) {
                _0x57c88f['push'](_0x57c88f['shift']())
            }
        };
        _0x4b2391(++_0x2383d8)
    }(__0x6d4a2, 0xad));
    var _0x1691 = function (_0x3c08d1, _0xc096f) {
        _0x3c08d1 = _0x3c08d1 - 0x0;
        var _0x2babb8 = __0x6d4a2[_0x3c08d1];
        if (_0x1691['initialized'] === undefined) {
            (function () {
                var _0x2f1e69 = typeof window !== 'undefined' ? window : typeof process === 'object' && typeof require === 'function' && typeof global === 'object' ? global : this;
                var _0x4f603c = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
                _0x2f1e69['atob'] || (_0x2f1e69['atob'] = function (_0x2c68bb) {
                    var _0x492998 = String(_0x2c68bb)['replace'](/=+$/, '');
                    for (var _0x5ee61a = 0x0, _0x2ac634, _0x1d1013, _0x6f4d80 = 0x0, _0x4a006d = ''; _0x1d1013 = _0x492998['charAt'](_0x6f4d80++); ~_0x1d1013 && (_0x2ac634 = _0x5ee61a % 0x4 ? _0x2ac634 * 0x40 + _0x1d1013 : _0x1d1013, _0x5ee61a++ % 0x4) ? _0x4a006d += String['fromCharCode'](0xff & _0x2ac634 >> (-0x2 * _0x5ee61a & 0x6)) : 0x0) {
                        _0x1d1013 = _0x4f603c['indexOf'](_0x1d1013)
                    }
                    return _0x4a006d
                })
            }());
            var _0xa0b1f0 = function (_0x2fa32b, _0x4608dc) {
                var _0x4f2019 = [], _0x4a28e8 = 0x0, _0x19767d, _0x4cf800 = '', _0x4bb512 = '';
                _0x2fa32b = atob(_0x2fa32b);
                for (var _0x36c759 = 0x0, _0x20d6ad = _0x2fa32b['length']; _0x36c759 < _0x20d6ad; _0x36c759++) {
                    _0x4bb512 += '%' + ('00' + _0x2fa32b['charCodeAt'](_0x36c759)['toString'](0x10))['slice'](-0x2)
                }
                _0x2fa32b = decodeURIComponent(_0x4bb512);
                for (var _0x3ac32b = 0x0; _0x3ac32b < 0x100; _0x3ac32b++) {
                    _0x4f2019[_0x3ac32b] = _0x3ac32b
                }
                for (_0x3ac32b = 0x0; _0x3ac32b < 0x100; _0x3ac32b++) {
                    _0x4a28e8 = (_0x4a28e8 + _0x4f2019[_0x3ac32b] + _0x4608dc['charCodeAt'](_0x3ac32b % _0x4608dc['length'])) % 0x100;
                    _0x19767d = _0x4f2019[_0x3ac32b];
                    _0x4f2019[_0x3ac32b] = _0x4f2019[_0x4a28e8];
                    _0x4f2019[_0x4a28e8] = _0x19767d
                }
                _0x3ac32b = 0x0;
                _0x4a28e8 = 0x0;
                for (var _0x3b73f2 = 0x0; _0x3b73f2 < _0x2fa32b['length']; _0x3b73f2++) {
                    _0x3ac32b = (_0x3ac32b + 0x1) % 0x100;
                    _0x4a28e8 = (_0x4a28e8 + _0x4f2019[_0x3ac32b]) % 0x100;
                    _0x19767d = _0x4f2019[_0x3ac32b];
                    _0x4f2019[_0x3ac32b] = _0x4f2019[_0x4a28e8];
                    _0x4f2019[_0x4a28e8] = _0x19767d;
                    _0x4cf800 += String['fromCharCode'](_0x2fa32b['charCodeAt'](_0x3b73f2) ^ _0x4f2019[(_0x4f2019[_0x3ac32b] + _0x4f2019[_0x4a28e8]) % 0x100])
                }
                return _0x4cf800
            };
            _0x1691['rc4'] = _0xa0b1f0;
            _0x1691['data'] = {};
            _0x1691['initialized'] = !![]
        }
        var _0x4cce77 = _0x1691['data'][_0x3c08d1];
        if (_0x4cce77 === undefined) {
            if (_0x1691['once'] === undefined) {
                _0x1691['once'] = !![]
            }
            _0x2babb8 = _0x1691['rc4'](_0x2babb8, _0xc096f);
            _0x1691['data'][_0x3c08d1] = _0x2babb8
        } else {
            _0x2babb8 = _0x4cce77
        }
        return _0x2babb8
    };
    if (!![]) {
        f = function (_0x1d75de) {
            var _0x37083b = {
                'QPnEZ': function _0x60d408(_0x47b907, _0x1e139b) {
                    return _0x47b907 + _0x1e139b
                }, 'GfOGG': function _0x3d3c72(_0x1f55be, _0x4a6029) {
                    return _0x1f55be + _0x4a6029
                }, 'HMzQD': '=([^;]*)(;|$)'
            };
            var _0x4d0811,
                _0x524d79 = new RegExp(_0x37083b[_0x1691('0x0', 'H$R$')](_0x37083b[_0x1691('0x1', '@5Y)')]('(^|\x20)', _0x1d75de), _0x37083b[_0x1691('0x2', '&6Xe')]));
            if (_0x4d0811 = document[_0x1691('0x3', '@5Y)')][_0x1691('0x4', 'wcel')](_0x524d79)) {
                return unescape(_0x4d0811[0x2])
            } else {
                return null
            }
        };
        f2 = function (_0x5059ad, _0x4d7bb0) {
            var _0x372740 = {
                'wGmSQ': function _0x495870(_0x1e22e5, _0x5a96b1) {
                    return _0x1e22e5 + _0x5a96b1
                }, 'zPYil': function _0x53f643(_0x30ccee, _0x194f17) {
                    return _0x30ccee * _0x194f17
                }, 'PhIfk': function _0x5a75c7(_0x5ebe8a, _0x59b8e9) {
                    return _0x5ebe8a * _0x59b8e9
                }, 'HidQG': function _0x579a67(_0x374d40, _0x1e0498) {
                    return _0x374d40 + _0x1e0498
                }, 'bUfLy': function _0xd9d4c3(_0x490eda, _0xb0910e) {
                    return _0x490eda(_0xb0910e)
                }, 'DYZHd': _0x1691('0x5', 'wcel'), 'cDGyM': _0x1691('0x6', 'mI%7')
            };
            var _0x2d5246 = 0x1e;
            var _0x11d22b = new Date();
            _0x11d22b[_0x1691('0x7', 'V55E')](_0x372740[_0x1691('0x8', 'cvmk')](_0x11d22b[_0x1691('0x9', '2v0z')](), _0x372740[_0x1691('0xa', ']ZR@')](_0x372740[_0x1691('0xb', 'hPNq')](_0x372740[_0x1691('0xc', 'H$R$')](_0x372740['PhIfk'](_0x2d5246, 0x18), 0x3c), 0x3c), 0x3e8)));
            document[_0x1691('0xd', 'h%Wr')] = _0x372740['HidQG'](_0x372740[_0x1691('0xe', ']o&s')](_0x372740[_0x1691('0xf', 'd%V$')](_0x5059ad, '='), _0x372740['bUfLy'](escape, _0x4d7bb0)), _0x372740[_0x1691('0x10', 'nG4r')]) + _0x11d22b[_0x1691('0x11', 'U8Zj')]() + _0x372740['cDGyM']
        };
        try {
            ksub = f('k2')['slice'](-0x1);
            while (!![]) {
                t2 = new Date()['getTime']();
                if (t2['toString']()['slice'](-0x3)[_0x1691('0x12', '9f@X')](ksub) >= 0x0) {
                    f2('t2', t2);
                    break
                }
            }
        } catch (_0x5e3bb4) {
        }
    }
    ;
    if (!(typeof encode_version !== 'undefined' && encode_version === 'sojson.v5')) {
        window[_0x1691('0x13', 'EPWy')]('不能删除sojson.v5')
    }
    ;encode_version = 'sojson.v5';
    $.ajax({type: "get", url: "/send_comment?" + $('#comment_form').serialize(),}).success(function (message) {
        if ("{'err': '0'}" == message) {
            $("#comment_content").val("")
        } else {
            alert(message)
        }
    }).fail(function (err) {
        alert('未知错误')
    })
}

function __on_delcomment(_in_cid, _in_sid, _in_password) {
    const r_url = '/del_comment?' + ('cid=' + _in_cid) + ('&sid=' + _in_sid) + ('&password=' + _in_password);
    $.ajax({type: "get", url: r_url,}).success(function (message) {
        if ("{'err': '0'}" != message) {
            alert(message)
        }
        document.location.reload()
    }).fail(function (err) {
        alert('未知错误')
    })
}

function __get_detail_play_page_AID() {
    var AID = window.location.href.replace(/.*\/detail\/(\d{8}).*/, '$1');
    if (AID.length !== 8) {
        AID = window.location.href.replace(/.*\/play\/(\d{8}).*/, '$1')
    }
    return AID
}

function __set_on_sendcomment() {
    const AID = __get_detail_play_page_AID();
    $('#comment_id').attr('value', AID);
    $('#comment_form').on('submit', function () {
        __on_sendcomment();
        setTimeout(function () {
            __age_show_comments_page(0);
            event.preventDefault()
        }, 300)
    })
}

function __timeCycle(time) {
    var unixTimestamp = new Date(time * 1000);
    var Y = unixTimestamp.getFullYear(),
        M = ((unixTimestamp.getMonth() + 1) > 10 ? (unixTimestamp.getMonth() + 1) : '0' + (unixTimestamp.getMonth() + 1)),
        D = (unixTimestamp.getDate() > 10 ? unixTimestamp.getDate() : '0' + unixTimestamp.getDate()),
        h = (unixTimestamp.getHours() < 10) ? "0" + unixTimestamp.getHours() : unixTimestamp.getHours(),
        min = (unixTimestamp.getMinutes() < 10) ? "0" + unixTimestamp.getMinutes() : unixTimestamp.getMinutes(),
        s = (unixTimestamp.getSeconds() < 10) ? "0" + unixTimestamp.getSeconds() : unixTimestamp.getSeconds();
    return Y + '-' + M + '-' + D + " " + h + ":" + min + ":" + s
}

function __content_img_on(_content_val) {
    return _content_val;
    for (var i = 0; i < 3; i++) {
        var re_resl = _content_val.match(/(&lt;img +.+?&gt;)/);
        if (re_resl) {
            var src_img = "";
            var re_src = re_resl[1].match(/ +src=\"([^ \"\']+)\"/);
            if (re_src) {
                src_img = re_src[1]
            }
            var img_html = '<img referrerpolicy="no-referrer" src="' + src_img + '">';
            _content_val = _content_val.replace(re_resl[1], img_html)
        } else {
            break
        }
    }
    return _content_val
}

function html_fmt_comments_lis(_json_obj) {
    const _comments = _json_obj['comments'];
    const html_pageurls = _json_obj['html_pageurls'];
    var html_comment_lis = '';
    for (var i = 0; i < _comments.length; i++) {
        const comment_dict = _comments[i];
        const _sid = comment_dict['sid'];
        var _content_val = comment_dict['content'];
        _content_val = _content_val.replace(/\</g, '&lt;');
        _content_val = _content_val.replace(/\>/g, '&gt;');
        _content_val = __content_img_on(_content_val);
        const _time = __timeCycle(Number(comment_dict['time']));
        var _username = comment_dict['username'];
        _username = _username.replace(/\</g, '&lt;');
        _username = _username.replace(/\>/g, '&gt;');
        var html_li = '<li class="comment">';
        html_li += '<hr class="hrspace2">';
        html_li += ('<div class="commentcell_user">' + _username + '</div>');
        html_li += '<div class="commentcell_content">';
        html_li += ('<div>' + _content_val + '</div>');
        html_li += ('<div class="commentcell_time asciifont">' + _time + '</div>');
        html_li += '</div>';
        html_li += '</li>';
        html_comment_lis += html_li
    }
    html_comment_lis += '<hr class="hrspace2">';
    html_comment_lis += '<div id="current_comment_page" page=""></div>';
    $('#comment_list').html(html_comment_lis);
    $('.comment_page').html(html_pageurls)
}

/**
 * 放弃了上面的东西了
 * @param _in_cid
 * @param pageindex
 * @param pagesize
 * @private
 */
function __s_show_comments_page(_in_cid, pageindex, pagesize) {
    const r_url = "/get_comments?" + ('cid=' + _in_cid) + ('&pagesize=' + pagesize) + ('&pageindex=' + pageindex);
    $.ajax({type: "get", url: r_url,}).success(function (message) {
        const _json_obj = JSON.parse(message);
        html_fmt_comments_lis(_json_obj)
    }).fail(function (err) {
        alert('__s_show_comments_page failed')
    })
}

function __age_show_comments_page(pageindex) {
    const AID = __get_detail_play_page_AID();
    __s_show_comments_page(AID, pageindex, 10)
}
