# This is an abandoned project. 
# See https://github.com/mempoolexplorer/mempool-explorer-back for a self-hosted version.
# MempoolRecorder

This is a spring boot server to store in a mongo DB incoming blocks and the state of bitcoind mempool when a block is mined.
This server, as the rest of them in this folder follows a kind of microservice architecture using spring cloud framework. Bitcoind adapter serves data to this and other servers regarding new blocks and transactions. The way bitcoind adapter serves data is through a kafka topic (memPool.tx.events). 
MempoolRecorder listen to this kafka topic and stores the information in these DB documents:
* `StateOnNewBlock` (sonb): Store information about height, block data, transactions within, transactions in block but not in our mempool, mempool ancestry data for transactions in the block, and all transactions id in the mempool before the block is mined.
* `StateOnNewBlock` for disconected Blocks: Same information as above but for disconnected blocks. That is, blocks that has been overcome by others.
* `Transactions`: Full transaction data for transactions that exist in mempool when a block is mined. Be aware that this does not include deleted transactions overrided by others through bip125.
 
The idea is that Transactions document stores full tx data, and StateOnNewBlock documents refers to that transacions via its id. Ancestry data is also stored referring to that id.

Using this server, you can store and reproduce the mempool state as it was just before mining a block. This is useful for debuggin purpouses as well as future statistics.

MempoolRecorder is shutdown friendly. That is, if it's shutdown, ask bitcoindAdapter for the mempool and then listen to it's events. Also, if bitcoindAdapter is shutdown, mempoolRecorder will recognize this and will refresh its entire mempool when possible (by bitcoind signal).
## Requirements

* bitcoind 0.21
* java 11

## Usage

This is meant to be used in a docker environment. Go to commands folder to see docker-compose examples 

## REST API:


* `/alarms/list` List of errors or alarms of the service.
* `/pendingEvents/size` Number of pending events in the queue that not has been processed yet (to detect overload in the server).
* `/mempool/size` Size of the mempool of this server, it's usefull to see whether this number is the same in all servers to check everything is ok.
* `/fullStateOnNewBlock/hasBlock/{height}` Returns true or false depending of whether server has information of the block with that height.
* `/fullStateOnNewBlock/height/{height}` Retuns a `FullStateOnNewBlock` object containing the full state of the mempool just before the block with {height} arrived.
