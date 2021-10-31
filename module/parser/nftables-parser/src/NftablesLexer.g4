// Based on the http://git.netfilter.org/nftables/tree/src/scanner.l

lexer grammar NftablesLexer;

options { superClass = BaseLexer; }

channels { Shebang, Comments }

// todo: handle start of line
SHEBANG: '#!' ~[\r\n]* -> channel(Shebang);

EQ: '==' | 'eq';
NEQ: '!=' | 'ne';
LTE: '<=' | 'le';
LT: '<' | 'lt';
GTE: '>=' | 'ge';
GT: '>' | 'gt';
COMMA: ',';
DOT: '.';
COLON: ':';
SEMICOLON: ';';
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
OPEN_BRACKET: '[';
CLOSE_BRACKET: ']';
OPEN_PAREN: '(';
CLOSE_PAREN: ')';
LSHIFT: '<<' | 'lshift';
RSHIFT: '>>' | 'rshift';
CARET: '^' | 'xor';
AMPERSAND: '&' | 'and';
OR: 'or' | '|';
NOT: 'not' | '!';
SLASH: '/';
DASH: '-';
ASTERISK: '*';
AT: '@';
DOLLAR: '$';
EQUAL: '=';
VMAP: 'vmap';
PLUS: '+';
INCLUDE: 'include';
DEFINE: 'define';
REDEFINE: 'redefine';
UNDEFINE: 'undefine';
DESCRIBE: 'describe';
HOOK: 'hook';
DEVICE: 'device';
DEVICES: 'devices';
TABLE: 'table';
TABLES: 'tables';
CHAIN: 'chain';
CHAINS: 'chains';
RULE: 'rule';
RULES: 'rules';
SETS: 'sets';
SET: 'set';
ELEMENT: 'element';
MAP: 'map';
MAPS: 'maps';
FLOWTABLE: 'flowtable';
HANDLE: 'handle';
RULESET: 'ruleset';
TRACE: 'trace';

SOCKET: 'socket' { setInclusiveState(LexerState.EXPR_SOCKET); };
// EXPR_SOCKET | STMT_LOG states
TRANSPARENT: 'transparent' { isState(LexerState.EXPR_SOCKET) }?;
WILDCARD: 'wildcard' { isState(LexerState.EXPR_SOCKET) }?;
CGROUPV2: 'cgroupv2' { isState(LexerState.EXPR_SOCKET) }?;
LEVEL: 'level' { isState(LexerState.EXPR_SOCKET) || isState(LexerState.STMT_LOG) }?;

TPROXY: 'tproxy';

ACCEPT: 'accept';
DROP: 'drop';
CONTINUE: 'continue';
JUMP: 'jump';
GOTO: 'goto';
RETURN: 'return';
TO: 'to';

INET: 'inet';
NETDEV: 'netdev';

ADD: 'add';
REPLACE: 'replace';
UPDATE: 'update';
CREATE: 'create';
INSERT: 'insert';
DELETE: 'delete';
GET: 'get';

LIST: 'list' { setInclusiveState(LexerState.CMD_LIST); };
RESET: 'reset';
FLUSH: 'flush';
RENAME: 'rename';
IMPORT: 'import';
EXPORT: 'export';
MONITOR: 'monitor';

POSITION: 'position';
INDEX: 'index';
COMMENT: 'comment';

CONSTANT: 'constant';
INTERVAL: 'interval';
DYNAMIC: 'dynamic';
AUTOMERGE: 'auto-merge';
TIMEOUT: 'timeout';
GC_INTERVAL: 'gc-interval';
ELEMENTS: 'elements';
EXPIRES: 'expires';

POLICY: 'policy';
SIZE: 'size';
PERFORMANCE: 'performance';
MEMORY: 'memory';

FLOW: 'flow';
OFFLOAD: 'offload';
METER: 'meter';

// CMD_LIST state
METERS: 'meters' { isState(LexerState.CMD_LIST) }?;
FLOWTABLES: 'flowtables' { isState(LexerState.CMD_LIST) }?;
LIMITS: 'limits' { isState(LexerState.CMD_LIST) }?;
SECMARKS: 'secmarks' { isState(LexerState.CMD_LIST) }?;
SYNPROXYS: 'synproxys' { isState(LexerState.CMD_LIST) }?;
HOOKS: 'hooks' { isState(LexerState.CMD_LIST) }?;

COUNTER: 'counter' { setInclusiveState(LexerState.COUNTER); };
NAME: 'name';

// COUNTER | CT | LIMIT states
PACKETS: 'packets' { isState(LexerState.COUNTER) || isState(LexerState.CT) || isState(LexerState.LIMIT) }?;
// COUNTER | CT | LIMIT | QUOTA states
BYTES: 'bytes' { isState(LexerState.COUNTER) || isState(LexerState.CT) || isState(LexerState.LIMIT) || isState(LexerState.QUOTA) }?;

COUNTERS: 'counters';
QUOTAS: 'quotas';

LOG: 'log' { setInclusiveState(LexerState.STMT_LOG); };
PREFIX: 'prefix';
GROUP: 'group';
// STMT_LOG state
SNAPLEN: 'snaplen' { isState(LexerState.STMT_LOG) }?;
QUEUE_THRESHOLD: 'queue-threshold' { isState(LexerState.STMT_LOG) }?;

QUEUE: 'queue' { setInclusiveState(LexerState.EXPR_QUEUE); };
// <SCANSTATE_EXPR_QUEUE>
QUEUENUM: 'num' { isState(LexerState.EXPR_QUEUE) }?;
BYPASS: 'bypass' { isState(LexerState.EXPR_QUEUE) }?;
FANOUT: 'fanout' { isState(LexerState.EXPR_QUEUE) }?;
//
LIMIT: 'limit' { setInclusiveState(LexerState.LIMIT); };
// <SCANSTATE_LIMIT>
RATE: 'rate' { isState(LexerState.LIMIT) }?;
BURST: 'burst' { isState(LexerState.LIMIT) }?;
// <SCANSTATE_CT,SCANSTATE_LIMIT,SCANSTATE_QUOTA>
OVER: 'over' { isState(LexerState.CT) || isState(LexerState.LIMIT) || isState(LexerState.QUOTA) }?;

QUOTA: 'quota' { setInclusiveState(LexerState.QUOTA); };
// <SCANSTATE_QUOTA>
USED: 'used' { isState(LexerState.QUOTA) }?;
UNTIL: 'until' { isState(LexerState.QUOTA) }?;

SECOND: 'second';
MINUTE: 'minute';
HOUR: 'hour';
DAY: 'day';
WEEK: 'week';

REJECT: 'reject';
WITH: 'with';
ICMPX: 'icmpx';

SNAT: 'snat';
DNAT: 'dnat';
MASQUERADE: 'masquerade';
REDIRECT: 'redirect';
RANDOM: 'random';
FULLY_RANDOM: 'fully-random';
PERSISTENT: 'persistent';

LL_HDR: 'll';
NETWORK_HDR: 'nh';
TRANSPORT_HDR: 'th';

BRIDGE: 'bridge';

ETHER: 'ether' { setInclusiveState(LexerState.ETH); };
// <SCANSTATE_ARP,SCANSTATE_CT,SCANSTATE_ETH,SCANSTATE_IP,SCANSTATE_IP6,SCANSTATE_EXPR_FIB,SCANSTATE_EXPR_IPSEC>
SADDR: 'saddr' { isState(LexerState.ARP) || isState(LexerState.CT) || isState(LexerState.ETH) || isState(LexerState.IP) || isState(LexerState.IP6) || isState(LexerState.EXPR_FIB) || isState(LexerState.EXPR_IPSEC) }?;
DADDR: 'daddr' { isState(LexerState.ARP) || isState(LexerState.CT) || isState(LexerState.ETH) || isState(LexerState.IP) || isState(LexerState.IP6) || isState(LexerState.EXPR_FIB) || isState(LexerState.EXPR_IPSEC) }?;
//
TYPE: 'type';
TYPEOF: 'typeof';

VLAN: 'vlan' { setInclusiveState(LexerState.VLAN); };
ID: 'id';
// <SCANSTATE_VLAN>
CFI: 'cfi' { isState(LexerState.VLAN) }?;
DEI: 'dei' { isState(LexerState.VLAN) }?;
PCP: 'pcp' { isState(LexerState.VLAN) }?;
T8021AD: '8021ad';
T8021Q: '8021q';

ARP: 'arp' { setInclusiveState(LexerState.ARP); };
// <SCANSTATE_ARP>
HTYPE: 'htype' { isState(LexerState.ARP) }?;
PTYPE: 'ptype' { isState(LexerState.ARP) }?;
HLEN: 'hlen' { isState(LexerState.ARP) }?;
PLEN: 'plen' { isState(LexerState.ARP) }?;
OPERATION: 'operation' { isState(LexerState.ARP) }?;

IP: 'ip' { setInclusiveState(LexerState.IP); };
HDRVERSION: 'version';
HDRLENGTH: 'hdrlength';
DSCP: 'dscp';
ECN: 'ecn';
LENGTH: 'length';
FRAG_OFF: 'frag-off';
TTL: 'ttl';
PROTOCOL: 'protocol';
CHECKSUM: 'checksum';
// <SCANSTATE_IP>
LSRR: 'lsrr' { isState(LexerState.IP) }?;
RR: 'rr' { isState(LexerState.IP) }?;
SSRR: 'ssrr' { isState(LexerState.IP) }?;
RA: 'ra'  { isState(LexerState.IP) }?;
PTR: 'ptr'  { isState(LexerState.IP) }?;
VALUE: 'value' { isState(LexerState.IP) }?;

ECHO: 'echo';
EOL: 'eol';
MAXSEG: 'maxseg';
MSS: 'mss';
NOP: 'nop';
NOOP: 'noop';
SACK: 'sack';
SACK0: 'sack0';
SACK1: 'sack1';
SACK2: 'sack2';
SACK3: 'sack3';
SACK_PERMITTED: 'sack-permitted';
SACK_PERM: 'sack-perm';
TIMESTAMP: 'timestamp';
TIME: 'time';

KIND: 'kind';
COUNT: 'count';
LEFT: 'left';
RIGHT: 'right';
TSVAL: 'tsval';
TSECR: 'tsecr';

ICMP: 'icmp';
CODE: 'code';
SEQUENCE: 'sequence';
GATEWAY: 'gateway';
MTU: 'mtu';

IGMP: 'igmp';
MRT: 'mrt';

IP6: 'ip6' { setInclusiveState(LexerState.IP6); };
PRIORITY: 'priority';
// <SCANSTATE_IP6>
FLOWLABEL: 'flowlabel' { isState(LexerState.IP6) }?;
HOPLIMIT: 'hoplimit' { isState(LexerState.IP6) }?;
NEXTHDR: 'nexthdr';

ICMP6: 'icmpv6';
PPTR: 'param-problem';
MAXDELAY: 'max-delay';

AH: 'ah';
RESERVED: 'reserved';
SPI: 'spi';

ESP: 'esp';

COMP: 'comp';
FLAGS: 'flags';
CPI: 'cpi';

UDP: 'udp';
UDPLITE: 'udplite';
SPORT: 'sport';
DPORT: 'dport';
PORT: 'port';

TCP: 'tcp';
ACKSEQ: 'ackseq';
DOFF: 'doff';
WINDOW: 'window';
URGPTR: 'urgptr';
OPTION: 'option';

DCCP: 'dccp';

SCTP: 'sctp' { setInclusiveState(LexerState.SCTP); };
// <SCANSTATE_SCTP>
CHUNK: 'chunk' { isState(LexerState.SCTP) }? { setInclusiveState(LexerState.EXPR_SCTP_CHUNK); };
VTAG: 'vtag' { isState(LexerState.SCTP) }?;
// <SCANSTATE_EXPR_SCTP_CHUNK>
DATA: 'data' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
INIT: 'init' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
INIT_ACK: 'init-ack' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
HEARTBEAT: 'heartbeat' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
HEARTBEAT_ACK: 'heartbeat-ack' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
ABORT: 'abort' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
SHUTDOWN: 'shutdown' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
SHUTDOWN_ACK: 'shutdown-ack' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
ERROR: 'error' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
COOKIE_ECHO: 'cookie-echo' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
COOKIE_ACK: 'cookie-ack' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
ECNE: 'ecne' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
CWR: 'cwr' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
SHUTDOWN_COMPLETE: 'shutdown-complete' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
ASCONF_ACK: 'asconf-ack' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
FORWARD_TSN: 'forward-tsn' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
ASCONF: 'asconf' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
TSN: 'tsn' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
STREAM: 'stream' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
SSN: 'ssn' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
PPID: 'ppid' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
INIT_TAG: 'init-tag' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
A_RWND: 'a-rwnd' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
NUM_OSTREAMS: 'num-outbound-streams' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
NUM_ISTREAMS: 'num-inbound-streams' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
INIT_TSN: 'initial-tsn' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
CUM_TSN_ACK: 'cum-tsn-ack' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
NUM_GACK_BLOCKS: 'num-gap-ack-blocks' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
NUM_DUP_TSNS: 'num-dup-tsns' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
LOWEST_TSN: 'lowest-tsn' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
SEQNO: 'seqno' { isState(LexerState.EXPR_SCTP_CHUNK) }?;
NEW_CUM_TSN: 'new-cum-tsn' { isState(LexerState.EXPR_SCTP_CHUNK) }?;

RT: 'rt' { setInclusiveState(LexerState.EXPR_RT); };
RT0: 'rt0';
RT2: 'rt2';
RT4: 'srh';
SEG_LEFT: 'seg-left';
ADDR: 'addr';
LAST_ENT: 'last-entry';
TAG: 'tag';
SID: 'sid';

HBH: 'hbh';

FRAG: 'frag';
RESERVED2: 'reserved2';
MORE_FRAGMENTS: 'more-fragments';

DST: 'dst';

MH: 'mh';

META: 'meta';
MARK: 'mark';
IIF: 'iif';
IIFNAME: 'iifname';
IIFTYPE: 'iiftype';
OIF: 'oif';
OIFNAME: 'oifname';
OIFTYPE: 'oiftype';
SKUID: 'skuid';
SKGID: 'skgid';
NFTRACE: 'nftrace';
RTCLASSID: 'rtclassid';
IBRIPORT: 'ibriport';
IBRIDGENAME: 'ibrname';
OBRIPORT: 'obriport';
OBRIDGENAME: 'obrname';
PKTTYPE: 'pkttype';
CPU: 'cpu';
IIFGROUP: 'iifgroup';
OIFGROUP: 'oifgroup';
CGROUP: 'cgroup';

// <SCANSTATE_EXPR_RT>
CLASSID: 'classid' { isState(LexerState.EXPR_RT) }?;
NEXTHOP: 'nexthop' { isState(LexerState.EXPR_RT) }?;

CT: 'ct' { setInclusiveState(LexerState.CT); };
// <SCANSTATE_CT>
AVGPKT: 'avgpkt' { isState(LexerState.CT) }?;
L3PROTOCOL: 'l3proto' { isState(LexerState.CT) }?;
PROTO_SRC: 'proto-src' { isState(LexerState.CT) }?;
PROTO_DST: 'proto-dst' { isState(LexerState.CT) }?;
ZONE: 'zone' { isState(LexerState.CT) }?;
ORIGINAL: 'original' { isState(LexerState.CT) }?;
REPLY: 'reply' { isState(LexerState.CT) }?;
DIRECTION: 'direction' { isState(LexerState.CT) }?;
EVENT: 'event' { isState(LexerState.CT) }?;
EXPECTATION: 'expectation' { isState(LexerState.CT) }?;
EXPIRATION: 'expiration' { isState(LexerState.CT) }?;
HELPER: 'helper' { isState(LexerState.CT) }?;
HELPERS: 'helpers' { isState(LexerState.CT) }?;
LABEL: 'label' { isState(LexerState.CT) }?;
STATE: 'state' { isState(LexerState.CT) }?;
STATUS: 'status' { isState(LexerState.CT) }?;

NUMGEN: 'numgen' { setInclusiveState(LexerState.EXPR_NUMGEN); };
// <SCANSTATE_EXPR_NUMGEN>
INC: 'inc' { isState(LexerState.EXPR_NUMGEN) }?;

JHASH: 'jhash' { setInclusiveState(LexerState.EXPR_HASH); };
SYMHASH: 'symhash' { setInclusiveState(LexerState.EXPR_HASH); };
// <SCANSTATE_EXPR_HASH>
SEED: 'seed' { isState(LexerState.EXPR_HASH) }?;
// <SCANSTATE_EXPR_HASH,SCANSTATE_EXPR_NUMGEN>
MOD: 'mod' {
    //writeLog(state, isState(LexerState.EXPR_HASH) || isState(LexerState.EXPR_NUMGEN))
    isState(LexerState.EXPR_HASH) || isState(LexerState.EXPR_NUMGEN)
}?;
OFFSET: 'offset' { isState(LexerState.EXPR_HASH) || isState(LexerState.EXPR_NUMGEN) }?;
DUP: 'dup';
FWD: 'fwd';

FIB: 'fib' { setInclusiveState(LexerState.EXPR_FIB); };

OSF: 'osf';

SYNPROXY: 'synproxy';

WSCALE: 'wscale';
NOTRACK: 'notrack';

OPTIONS: 'options';
ALL: 'all';

XML: 'xml';
JSON: 'json';
VM: 'vm';

EXISTS: 'exists';
MISSING: 'missing';

EXTHDR: 'exthdr';

IPSEC: 'ipsec' { setInclusiveState(LexerState.EXPR_IPSEC); };
// <SCANSTATE_EXPR_IPSEC>
REQID: 'reqid' { isState(LexerState.EXPR_IPSEC) }?;
SPNUM: 'spnum' { isState(LexerState.EXPR_IPSEC) }?;
IN: 'in' { isState(LexerState.EXPR_IPSEC) }?;
OUT: 'out' { isState(LexerState.EXPR_IPSEC) }?;

SECMARK: 'secmark' { setInclusiveState(LexerState.SECMARK); };

CSUMCOV: 'csumcov';

ADDRSTRING: (MacAddr | Ip4Addr | Ip6Addr) -> type(STRING);
IP6ADDR_RFC2732: '[' Ip6Addr ']' -> type(STRING);

// NB: We use different pattern as the Bison's pattern can match an empty string, but ANTLR's can't.
TIME_STRING: Digit+ ('d' | 'h' | 'm' | 's' | 'ms')+ -> type(STRING);

NUM: DecString | HexString;

CLASSID_STRING: Classid '/' [ \t\n:\-},] -> type(STRING);

QUOTED_STRING: '"' ~'"'* '"';

ASTERISK_STRING: (String '*' | String '\\*' | '\\*' | String '\\*' String);

STRING: String;

ESCAPED_NEWLINE: '\\'Newline -> skip;
NEWLINE: Newline;

WS: Ws -> skip;
// todo: how to use the channel?
SINGLE_LINE_COMMENT: '#' ~[\r\n]* -> channel(Comments);

//todo:
//SHEBANG: {this.SOF()}? '\ufeff'? '#!' ~[\r\n]* -> channel(HIDDEN);

//JUNK: .;

fragment Letter: [a-zA-Z];
fragment Digit: [0-9];
fragment DecString: Digit+;
fragment HexString: '0'[xX]HexDigit+;
fragment HexDigit: [0-9a-fA-F];
fragment String: (Letter | [_.])(Letter | Digit | [-/\\_.])*;
fragment Ws: [\t ]+;
fragment Newline: [\r\n];
fragment Classid: HexSeq ':' HexSeq;
fragment HexSeq: (HexDigit | HexDigit HexDigit | HexDigit HexDigit HexDigit | HexDigit HexDigit HexDigit HexDigit);

fragment MacAddr: MacAddrDigitPrefix MacAddrDigitPrefix MacAddrDigitPrefix MacAddrDigitPrefix MacAddrDigitPrefix MacAddrDigit;
fragment MacAddrDigitPrefix: MacAddrDigit ':';
fragment MacAddrDigit: (HexDigit | HexDigit HexDigit);

fragment Ip4Addr: Ip4AddrDigitPrefix Ip4AddrDigitPrefix Ip4AddrDigitPrefix Ip4AddrDigit;
fragment Ip4AddrDigit: (Digit | Digit Digit | Digit Digit Digit);
fragment Ip4AddrDigitPrefix: Ip4AddrDigit '.';

fragment Ip6Addr: (V680 | V67 | V66 | V65 | V64 | V63 | V62 | V61 | V60);
fragment Hex4: (HexDigit | HexDigit HexDigit | HexDigit HexDigit HexDigit | HexDigit HexDigit HexDigit HexDigit);
fragment Hex4Prefix: Hex4 ':';
fragment Hex4Suffix: ':' Hex4;

fragment Hex4Prefix7: Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix;
fragment Hex4Prefix6: Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix;
fragment Hex4Prefix5: Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix;
fragment Hex4Prefix4: Hex4Prefix Hex4Prefix Hex4Prefix Hex4Prefix;
fragment Hex4Prefix3: Hex4Prefix Hex4Prefix Hex4Prefix;
fragment Hex4Prefix2: Hex4Prefix Hex4Prefix;

fragment Hex4Suffix7: Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix;
fragment Hex4Suffix6: Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix;
fragment Hex4Suffix5: Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix;
fragment Hex4Suffix4: Hex4Suffix Hex4Suffix Hex4Suffix Hex4Suffix;
fragment Hex4Suffix3: Hex4Suffix Hex4Suffix Hex4Suffix;
fragment Hex4Suffix2: Hex4Suffix Hex4Suffix;

fragment V680: Hex4Prefix7 Hex4;
fragment V670: ':' Hex4Suffix7;
fragment V671: Hex4Prefix Hex4Suffix6;
fragment V672: Hex4Prefix2 Hex4Suffix5;
fragment V673: Hex4Prefix3 Hex4Suffix4;
fragment V674: Hex4Prefix4 Hex4Suffix3;
fragment V675: Hex4Prefix5 Hex4Suffix2;
fragment V676: Hex4Prefix6 Hex4Suffix;
fragment V677: Hex4Prefix7 ':';
fragment V67:  (V670 | V671 | V672 | V673 | V674 | V675 | V676 | V677); 
fragment V660: ':' Hex4Suffix6;
fragment V661: Hex4Prefix Hex4Suffix5;
fragment V662: Hex4Prefix2 Hex4Suffix4;
fragment V663: Hex4Prefix3 Hex4Suffix3;
fragment V664: Hex4Prefix4 Hex4Suffix2;
fragment V665: Hex4Prefix5 Hex4Suffix;
fragment V666: Hex4Prefix6 ':';
fragment V66: (V660| V661 | V662 | V663 | V664 | V665 | V666);
fragment V650: ':' Hex4Suffix5;
fragment V651: Hex4Prefix Hex4Suffix4;
fragment V652: Hex4Prefix2 Hex4Suffix3;
fragment V653: Hex4Prefix3 Hex4Suffix2;
fragment V654: Hex4Prefix4 Hex4Suffix;
fragment V655: Hex4Prefix5 ':';
fragment V65: (V650 | V651 | V652 | V653 | V654 | V655);
fragment V640: ':' Hex4Suffix4;
fragment V641: Hex4Prefix Hex4Suffix3;
fragment V642: Hex4Prefix2 Hex4Suffix2;
fragment V643: Hex4Prefix3 Hex4Suffix;
fragment V644: Hex4Prefix4 ':';
fragment V64: (V640 | V641 | V642 | V643 | V644);
fragment V630: ':' Hex4Suffix3;
fragment V631: Hex4Prefix Hex4Suffix2;
fragment V632: Hex4Prefix2 Hex4Suffix;
fragment V633: Hex4Prefix3 ':';
fragment V63: (V630 | V631 | V632 | V633);
fragment V620: ':' Hex4Suffix2;
fragment V620Rfc4291: '::' Ip4Addr;
fragment V621: Hex4Prefix Hex4Suffix;
fragment V622: Hex4Prefix2 ':';
fragment V62Rfc4291: ':' FfSuffix4 ':' Ip4Addr;
fragment FfSuffix4: ':' [fF] [fF] [fF] [fF];
fragment V62: (V620 | V621 | V622 | V62Rfc4291 | V620Rfc4291);
fragment V610: ':' Hex4Suffix;
fragment V611: Hex4Prefix ':';
fragment V61: (V610 | V611);
fragment V60: '::';