package bussinesslogic.TeamTech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import PO.TeamTechPO;
import TypeEnum.SortEnum;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import bussinesslogic.Transfer.P2L.TeamTechP2L;
import data.TeamTechData;
import dataservice.TeamTechDataService;

public class TeamTech {
	TeamTechDataService ttds = new TeamTechData();
	
	public ArrayList<TeamTechLineItem> Ascend(TeamTechEnum DataType, boolean high, boolean avg) {
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();
		if(DataType.equals(TeamTechEnum.name)){
			ArrayList<TeamTechLineItem> result = new ArrayList<TeamTechLineItem>();
			for(int i = 0; i<30; i++){
				TeamTechP2L p2l = new TeamTechP2L();
				result.add(p2l.p2l(list.get(i)));
			}
			return result;
		}
		
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		
		if(high==false){
			if(avg==false){
				Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
					public int compare(TeamTechLineItem t1, TeamTechLineItem t2){
						switch(DataType){
						case score:
							if(t1.score==t2.score){
								if(t1.rebound==t2.rebound){
									if(t1.secondaryAttack==t2.secondaryAttack){
										if(t1.blockShot==t2.blockShot){
											if(t1.steal==t2.steal){
												if(t1.foul==t2.foul){
													if(t1.fault==t2.fault){
														if(t1.shotInRate==t2.shotInRate){
															if(t1.threeShotInRate==t2.threeShotInRate){
																if(t1.penaltyShotInRate==t2.penaltyShotInRate){
																	if(t1.defensiveRebound==t2.defensiveRebound){
																		if(t1.offensiveRebound==t2.offensiveRebound){
																			return 0;
																		}
																		return t1.offensiveRebound-t2.offensiveRebound;
																	}
																	return t1.defensiveRebound-t2.defensiveRebound;
																}
																return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
															}
															return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
														}
														return (t1.shotInRate-t2.shotInRate)>0?1:-1;
													}
													return t1.fault-t2.fault;
												}
												return t1.foul-t2.foul;
											}
											return t1.steal-t2.steal;
										}
										return t1.blockShot-t2.blockShot;
									}
									return t1.secondaryAttack-t2.secondaryAttack;
								}
								return t1.rebound-t2.rebound;
							}
							return t1.score-t2.score;
						case rebound:
							if(t1.rebound==t2.rebound){
								if(t1.secondaryAttack==t2.secondaryAttack){
									if(t1.blockShot==t2.blockShot){
										if(t1.steal==t2.steal){
											if(t1.foul==t2.foul){
												if(t1.fault==t2.fault){
													if(t1.shotInRate==t2.shotInRate){
														if(t1.threeShotInRate==t2.threeShotInRate){
															if(t1.penaltyShotInRate==t2.penaltyShotInRate){
																if(t1.defensiveRebound==t2.defensiveRebound){
																	if(t1.offensiveRebound==t2.offensiveRebound){
																		return 0;
																	}
																	return t1.offensiveRebound-t2.offensiveRebound;
																}
																return t1.defensiveRebound-t2.defensiveRebound;
															}
															return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
														}
														return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
													}
													return (t1.shotInRate-t2.shotInRate)>0?1:-1;
												}
												return t1.fault-t2.fault;
											}
											return t1.foul-t2.foul;
										}
										return t1.steal-t2.steal;
									}
									return t1.blockShot-t2.blockShot;
								}
								return t1.secondaryAttack-t2.secondaryAttack;
							}
							return t1.rebound-t2.rebound;
						case secondaryAttack:
							if(t1.secondaryAttack==t2.secondaryAttack){
								if(t1.blockShot==t2.blockShot){
									if(t1.steal==t2.steal){
										if(t1.foul==t2.foul){
											if(t1.fault==t2.fault){
												if(t1.shotInRate==t2.shotInRate){
													if(t1.threeShotInRate==t2.threeShotInRate){
														if(t1.penaltyShotInRate==t2.penaltyShotInRate){
															if(t1.defensiveRebound==t2.defensiveRebound){
																if(t1.offensiveRebound==t2.offensiveRebound){
																	return 0;
																}
																return t1.offensiveRebound-t2.offensiveRebound;
															}
															return t1.defensiveRebound-t2.defensiveRebound;
														}
														return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
													}
													return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
												}
												return (t1.shotInRate-t2.shotInRate)>0?1:-1;
											}
											return t1.fault-t2.fault;
										}
										return t1.foul-t2.foul;
									}
									return t1.steal-t2.steal;
								}
								return t1.blockShot-t2.blockShot;
							}
							return t1.secondaryAttack-t2.secondaryAttack;
						case blockShot:
							if(t1.blockShot==t2.blockShot){
								if(t1.steal==t2.steal){
									if(t1.foul==t2.foul){
										if(t1.fault==t2.fault){
											if(t1.shotInRate==t2.shotInRate){
												if(t1.threeShotInRate==t2.threeShotInRate){
													if(t1.penaltyShotInRate==t2.penaltyShotInRate){
														if(t1.defensiveRebound==t2.defensiveRebound){
															if(t1.offensiveRebound==t2.offensiveRebound){
																return 0;
															}
															return t1.offensiveRebound-t2.offensiveRebound;
														}
														return t1.defensiveRebound-t2.defensiveRebound;
													}
													return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
												}
												return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
											}
											return (t1.shotInRate-t2.shotInRate)>0?1:-1;
										}
										return t1.fault-t2.fault;
									}
									return t1.foul-t2.foul;
								}
								return t1.steal-t2.steal;
							}
							return t1.blockShot-t2.blockShot;
						case steal:
							if(t1.steal==t2.steal){
								if(t1.foul==t2.foul){
									if(t1.fault==t2.fault){
										if(t1.shotInRate==t2.shotInRate){
											if(t1.threeShotInRate==t2.threeShotInRate){
												if(t1.penaltyShotInRate==t2.penaltyShotInRate){
													if(t1.defensiveRebound==t2.defensiveRebound){
														if(t1.offensiveRebound==t2.offensiveRebound){
															return 0;
														}
														return t1.offensiveRebound-t2.offensiveRebound;
													}
													return t1.defensiveRebound-t2.defensiveRebound;
												}
												return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
											}
											return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
										}
										return (t1.shotInRate-t2.shotInRate)>0?1:-1;
									}
									return t1.fault-t2.fault;
								}
								return t1.foul-t2.foul;
							}
							return t1.steal-t2.steal;
						case foul:
							if(t1.foul==t2.foul){
								if(t1.fault==t2.fault){
									if(t1.shotInRate==t2.shotInRate){
										if(t1.threeShotInRate==t2.threeShotInRate){
											if(t1.penaltyShotInRate==t2.penaltyShotInRate){
												if(t1.defensiveRebound==t2.defensiveRebound){
													if(t1.offensiveRebound==t2.offensiveRebound){
														return 0;
													}
													return t1.offensiveRebound-t2.offensiveRebound;
												}
												return t1.defensiveRebound-t2.defensiveRebound;
											}
											return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
										}
										return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
									}
									return (t1.shotInRate-t2.shotInRate)>0?1:-1;
								}
								return t1.fault-t2.fault;
							}
							return t1.foul-t2.foul;
						case fault:
							if(t1.fault==t2.fault){
								if(t1.shotInRate==t2.shotInRate){
									if(t1.threeShotInRate==t2.threeShotInRate){
										if(t1.penaltyShotInRate==t2.penaltyShotInRate){
											if(t1.defensiveRebound==t2.defensiveRebound){
												if(t1.offensiveRebound==t2.offensiveRebound){
													return 0;
												}
												return t1.offensiveRebound-t2.offensiveRebound;
											}
											return t1.defensiveRebound-t2.defensiveRebound;
										}
										return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
									}
									return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
								}
								return (t1.shotInRate-t2.shotInRate)>0?1:-1;
							}
							return t1.fault-t2.fault;
						case shotInRate:
							if(t1.shotInRate==t2.shotInRate){
								if(t1.threeShotInRate==t2.threeShotInRate){
									if(t1.penaltyShotInRate==t2.penaltyShotInRate){
										if(t1.defensiveRebound==t2.defensiveRebound){
											if(t1.offensiveRebound==t2.offensiveRebound){
												return 0;
											}
											return t1.offensiveRebound-t2.offensiveRebound;
										}
										return t1.defensiveRebound-t2.defensiveRebound;
									}
									return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
								}
								return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
							}
							return (t1.shotInRate-t2.shotInRate)>0?1:-1;
						case threeShotInRate:
							if(t1.threeShotInRate==t2.threeShotInRate){
								if(t1.penaltyShotInRate==t2.penaltyShotInRate){
									if(t1.defensiveRebound==t2.defensiveRebound){
										if(t1.offensiveRebound==t2.offensiveRebound){
											return 0;
										}
										return t1.offensiveRebound-t2.offensiveRebound;
									}
									return t1.defensiveRebound-t2.defensiveRebound;
								}
								return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
							}
							return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
						case penaltyShotInRate:
							if(t1.penaltyShotInRate==t2.penaltyShotInRate){
								if(t1.defensiveRebound==t2.defensiveRebound){
									if(t1.offensiveRebound==t2.offensiveRebound){
										return 0;
									}
									return t1.offensiveRebound-t2.offensiveRebound;
								}
								return t1.defensiveRebound-t2.defensiveRebound;
							}
							return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
						case defensiveRebound:
							if(t1.defensiveRebound==t2.defensiveRebound){
								if(t1.offensiveRebound==t2.offensiveRebound){
									return 0;
								}
								return t1.offensiveRebound-t2.offensiveRebound;
							}
							return t1.defensiveRebound-t2.defensiveRebound;
						case offensiveRebound:
							return t1.offensiveRebound-t2.offensiveRebound;
						default:
							return 0;
						}
					}

				};
			}else{
				Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
					public int compare(TeamTechLineItem t1, TeamTechLineItem t2){
						switch(DataType){
						case score:
							if(t1.score==t2.score){
								if(t1.rebound==t2.rebound){
									if(t1.secondaryAttack==t2.secondaryAttack){
										if(t1.blockShot==t2.blockShot){
											if(t1.steal==t2.steal){
												if(t1.foul==t2.foul){
													if(t1.fault==t2.fault){
														if(t1.shotInRate==t2.shotInRate){
															if(t1.threeShotInRate==t2.threeShotInRate){
																if(t1.penaltyShotInRate==t2.penaltyShotInRate){
																	if(t1.defensiveRebound==t2.defensiveRebound){
																		if(t1.offensiveRebound==t2.offensiveRebound){
																			return 0;
																		}
																		return t1.offensiveRebound-t2.offensiveRebound;
																	}
																	return t1.defensiveRebound-t2.defensiveRebound;
																}
																return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
															}
															return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
														}
														return (t1.shotInRate-t2.shotInRate)>0?1:-1;
													}
													return t1.fault-t2.fault;
												}
												return t1.foul-t2.foul;
											}
											return t1.steal-t2.steal;
										}
										return t1.blockShot-t2.blockShot;
									}
									return t1.secondaryAttack-t2.secondaryAttack;
								}
								return t1.rebound-t2.rebound;
							}
							return t1.score-t2.score;
						case rebound:
							if(t1.rebound==t2.rebound){
								if(t1.secondaryAttack==t2.secondaryAttack){
									if(t1.blockShot==t2.blockShot){
										if(t1.steal==t2.steal){
											if(t1.foul==t2.foul){
												if(t1.fault==t2.fault){
													if(t1.shotInRate==t2.shotInRate){
														if(t1.threeShotInRate==t2.threeShotInRate){
															if(t1.penaltyShotInRate==t2.penaltyShotInRate){
																if(t1.defensiveRebound==t2.defensiveRebound){
																	if(t1.offensiveRebound==t2.offensiveRebound){
																		return 0;
																	}
																	return t1.offensiveRebound-t2.offensiveRebound;
																}
																return t1.defensiveRebound-t2.defensiveRebound;
															}
															return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
														}
														return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
													}
													return (t1.shotInRate-t2.shotInRate)>0?1:-1;
												}
												return t1.fault-t2.fault;
											}
											return t1.foul-t2.foul;
										}
										return t1.steal-t2.steal;
									}
									return t1.blockShot-t2.blockShot;
								}
								return t1.secondaryAttack-t2.secondaryAttack;
							}
							return t1.rebound-t2.rebound;
						case secondaryAttack:
							if(t1.secondaryAttack==t2.secondaryAttack){
								if(t1.blockShot==t2.blockShot){
									if(t1.steal==t2.steal){
										if(t1.foul==t2.foul){
											if(t1.fault==t2.fault){
												if(t1.shotInRate==t2.shotInRate){
													if(t1.threeShotInRate==t2.threeShotInRate){
														if(t1.penaltyShotInRate==t2.penaltyShotInRate){
															if(t1.defensiveRebound==t2.defensiveRebound){
																if(t1.offensiveRebound==t2.offensiveRebound){
																	return 0;
																}
																return t1.offensiveRebound-t2.offensiveRebound;
															}
															return t1.defensiveRebound-t2.defensiveRebound;
														}
														return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
													}
													return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
												}
												return (t1.shotInRate-t2.shotInRate)>0?1:-1;
											}
											return t1.fault-t2.fault;
										}
										return t1.foul-t2.foul;
									}
									return t1.steal-t2.steal;
								}
								return t1.blockShot-t2.blockShot;
							}
							return t1.secondaryAttack-t2.secondaryAttack;
						case blockShot:
							if(t1.blockShot==t2.blockShot){
								if(t1.steal==t2.steal){
									if(t1.foul==t2.foul){
										if(t1.fault==t2.fault){
											if(t1.shotInRate==t2.shotInRate){
												if(t1.threeShotInRate==t2.threeShotInRate){
													if(t1.penaltyShotInRate==t2.penaltyShotInRate){
														if(t1.defensiveRebound==t2.defensiveRebound){
															if(t1.offensiveRebound==t2.offensiveRebound){
																return 0;
															}
															return t1.offensiveRebound-t2.offensiveRebound;
														}
														return t1.defensiveRebound-t2.defensiveRebound;
													}
													return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
												}
												return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
											}
											return (t1.shotInRate-t2.shotInRate)>0?1:-1;
										}
										return t1.fault-t2.fault;
									}
									return t1.foul-t2.foul;
								}
								return t1.steal-t2.steal;
							}
							return t1.blockShot-t2.blockShot;
						case steal:
							if(t1.steal==t2.steal){
								if(t1.foul==t2.foul){
									if(t1.fault==t2.fault){
										if(t1.shotInRate==t2.shotInRate){
											if(t1.threeShotInRate==t2.threeShotInRate){
												if(t1.penaltyShotInRate==t2.penaltyShotInRate){
													if(t1.defensiveRebound==t2.defensiveRebound){
														if(t1.offensiveRebound==t2.offensiveRebound){
															return 0;
														}
														return t1.offensiveRebound-t2.offensiveRebound;
													}
													return t1.defensiveRebound-t2.defensiveRebound;
												}
												return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
											}
											return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
										}
										return (t1.shotInRate-t2.shotInRate)>0?1:-1;
									}
									return t1.fault-t2.fault;
								}
								return t1.foul-t2.foul;
							}
							return t1.steal-t2.steal;
						case foul:
							if(t1.foul==t2.foul){
								if(t1.fault==t2.fault){
									if(t1.shotInRate==t2.shotInRate){
										if(t1.threeShotInRate==t2.threeShotInRate){
											if(t1.penaltyShotInRate==t2.penaltyShotInRate){
												if(t1.defensiveRebound==t2.defensiveRebound){
													if(t1.offensiveRebound==t2.offensiveRebound){
														return 0;
													}
													return t1.offensiveRebound-t2.offensiveRebound;
												}
												return t1.defensiveRebound-t2.defensiveRebound;
											}
											return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
										}
										return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
									}
									return (t1.shotInRate-t2.shotInRate)>0?1:-1;
								}
								return t1.fault-t2.fault;
							}
							return t1.foul-t2.foul;
						case fault:
							if(t1.fault==t2.fault){
								if(t1.shotInRate==t2.shotInRate){
									if(t1.threeShotInRate==t2.threeShotInRate){
										if(t1.penaltyShotInRate==t2.penaltyShotInRate){
											if(t1.defensiveRebound==t2.defensiveRebound){
												if(t1.offensiveRebound==t2.offensiveRebound){
													return 0;
												}
												return t1.offensiveRebound-t2.offensiveRebound;
											}
											return t1.defensiveRebound-t2.defensiveRebound;
										}
										return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
									}
									return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
								}
								return (t1.shotInRate-t2.shotInRate)>0?1:-1;
							}
							return t1.fault-t2.fault;
						case shotInRate:
							if(t1.shotInRate==t2.shotInRate){
								if(t1.threeShotInRate==t2.threeShotInRate){
									if(t1.penaltyShotInRate==t2.penaltyShotInRate){
										if(t1.defensiveRebound==t2.defensiveRebound){
											if(t1.offensiveRebound==t2.offensiveRebound){
												return 0;
											}
											return t1.offensiveRebound-t2.offensiveRebound;
										}
										return t1.defensiveRebound-t2.defensiveRebound;
									}
									return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
								}
								return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
							}
							return (t1.shotInRate-t2.shotInRate)>0?1:-1;
						case threeShotInRate:
							if(t1.threeShotInRate==t2.threeShotInRate){
								if(t1.penaltyShotInRate==t2.penaltyShotInRate){
									if(t1.defensiveRebound==t2.defensiveRebound){
										if(t1.offensiveRebound==t2.offensiveRebound){
											return 0;
										}
										return t1.offensiveRebound-t2.offensiveRebound;
									}
									return t1.defensiveRebound-t2.defensiveRebound;
								}
								return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
							}
							return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
						case penaltyShotInRate:
							if(t1.penaltyShotInRate==t2.penaltyShotInRate){
								if(t1.defensiveRebound==t2.defensiveRebound){
									if(t1.offensiveRebound==t2.offensiveRebound){
										return 0;
									}
									return t1.offensiveRebound-t2.offensiveRebound;
								}
								return t1.defensiveRebound-t2.defensiveRebound;
							}
							return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
						case defensiveRebound:
							if(t1.defensiveRebound==t2.defensiveRebound){
								if(t1.offensiveRebound==t2.offensiveRebound){
									return 0;
								}
								return t1.offensiveRebound-t2.offensiveRebound;
							}
							return t1.defensiveRebound-t2.defensiveRebound;
						case offensiveRebound:
							return t1.offensiveRebound-t2.offensiveRebound;
						default:
							return 0;
						}
					}

				};
			}
			
			
			Collections.sort(forSort, comparator);
			return forSort;
		}else{
			Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
				public int compare(TeamTechLineItem t1, TeamTechLineItem t2){
					switch(DataType){
					case winningRate:
						if(t1.winningRate==t2.winningRate){
							if(t1.offensiveRound==t2.offensiveRound){
								if(t1.offensiveEfficiency==t2.offensiveEfficiency){
									if(t1.defensiveEfficiency==t2.defensiveEfficiency){
										if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
											if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
												if(t1.stealEfficiency==t2.stealEfficiency){
													if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
														return 0;
													}
													return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
												}
												return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
											}
											return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
										}
										return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
									}
									return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
								}
								return (t1.offensiveEfficiency-t2.offensiveEfficiency)>0?1:-1;
							}
							return (t1.offensiveRound-t2.offensiveRound)>0?1:-1;
						}
						return (t1.winningRate-t2.winningRate)>0?1:-1;
					case offensiveRound:
						if(t1.offensiveRound==t2.offensiveRound){
							if(t1.offensiveEfficiency==t2.offensiveEfficiency){
								if(t1.defensiveEfficiency==t2.defensiveEfficiency){
									if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
										if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
											if(t1.stealEfficiency==t2.stealEfficiency){
												if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
													return 0;
												}
												return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
											}
											return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
										}
										return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
									}
									return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
								}
								return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
							}
							return (t1.offensiveEfficiency-t2.offensiveEfficiency)>0?1:-1;
						}
						return (t1.offensiveRound-t2.offensiveRound)>0?1:-1;
					case offensiveEfficiency:
						if(t1.offensiveEfficiency==t2.offensiveEfficiency){
							if(t1.defensiveEfficiency==t2.defensiveEfficiency){
								if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
									if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
										if(t1.stealEfficiency==t2.stealEfficiency){
											if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
												return 0;
											}
											return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
										}
										return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
									}
									return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
								}
								return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
							}
							return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
						}
						return (t1.offensiveEfficiency-t2.offensiveEfficiency)>0?1:-1;
					case defensiveEfficiency:
						if(t1.defensiveEfficiency==t2.defensiveEfficiency){
							if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
								if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
									if(t1.stealEfficiency==t2.stealEfficiency){
										if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
											return 0;
										}
										return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
									}
									return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
								}
								return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
							}
							return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
						}
						return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
					case offensiveReboundEfficiency:
						if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
							if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
								if(t1.stealEfficiency==t2.stealEfficiency){
									if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
										return 0;
									}
									return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
								}
								return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
							}
							return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
						}
						return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
					case defensiveReboundEfficiency:
						if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
							if(t1.stealEfficiency==t2.stealEfficiency){
								if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
									return 0;
								}
								return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
							}
							return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
						}
						return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
					case stealEfficiency:
						if(t1.stealEfficiency==t2.stealEfficiency){
							if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
								return 0;
							}
							return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
						}
						return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
					case secondaryAttackEfficiency:
						return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
					default:
						return 0;
					}
				}
			};
			Collections.sort(forSort, comparator);
			return forSort;
		}
	}

	public ArrayList<TeamTechLineItem> Descend(TeamTechEnum DataType, boolean high) {
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();
		if(DataType.equals(TeamTechEnum.name)){
			ArrayList<TeamTechLineItem> result = new ArrayList<TeamTechLineItem>();
			for(int i = 0; i<30; i++){
				TeamTechP2L p2l = new TeamTechP2L();
				result.add(p2l.p2l(list.get(i)));
			}
			return result;
		}
		
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		
		if(high==false){
			Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
				public int compare(TeamTechLineItem t2, TeamTechLineItem t1){
					switch(DataType){
					case score:
						if(t1.score==t2.score){
							if(t1.rebound==t2.rebound){
								if(t1.secondaryAttack==t2.secondaryAttack){
									if(t1.blockShot==t2.blockShot){
										if(t1.steal==t2.steal){
											if(t1.foul==t2.foul){
												if(t1.fault==t2.fault){
													if(t1.shotInRate==t2.shotInRate){
														if(t1.threeShotInRate==t2.threeShotInRate){
															if(t1.penaltyShotInRate==t2.penaltyShotInRate){
																if(t1.defensiveRebound==t2.defensiveRebound){
																	if(t1.offensiveRebound==t2.offensiveRebound){
																		return 0;
																	}
																	return t1.offensiveRebound-t2.offensiveRebound;
																}
																return t1.defensiveRebound-t2.defensiveRebound;
															}
															return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
														}
														return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
													}
													return (t1.shotInRate-t2.shotInRate)>0?1:-1;
												}
												return t1.fault-t2.fault;
											}
											return t1.foul-t2.foul;
										}
										return t1.steal-t2.steal;
									}
									return t1.blockShot-t2.blockShot;
								}
								return t1.secondaryAttack-t2.secondaryAttack;
							}
							return t1.rebound-t2.rebound;
						}
						return t1.score-t2.score;
					case rebound:
						if(t1.rebound==t2.rebound){
							if(t1.secondaryAttack==t2.secondaryAttack){
								if(t1.blockShot==t2.blockShot){
									if(t1.steal==t2.steal){
										if(t1.foul==t2.foul){
											if(t1.fault==t2.fault){
												if(t1.shotInRate==t2.shotInRate){
													if(t1.threeShotInRate==t2.threeShotInRate){
														if(t1.penaltyShotInRate==t2.penaltyShotInRate){
															if(t1.defensiveRebound==t2.defensiveRebound){
																if(t1.offensiveRebound==t2.offensiveRebound){
																	return 0;
																}
																return t1.offensiveRebound-t2.offensiveRebound;
															}
															return t1.defensiveRebound-t2.defensiveRebound;
														}
														return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
													}
													return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
												}
												return (t1.shotInRate-t2.shotInRate)>0?1:-1;
											}
											return t1.fault-t2.fault;
										}
										return t1.foul-t2.foul;
									}
									return t1.steal-t2.steal;
								}
								return t1.blockShot-t2.blockShot;
							}
							return t1.secondaryAttack-t2.secondaryAttack;
						}
						return t1.rebound-t2.rebound;
					case secondaryAttack:
						if(t1.secondaryAttack==t2.secondaryAttack){
							if(t1.blockShot==t2.blockShot){
								if(t1.steal==t2.steal){
									if(t1.foul==t2.foul){
										if(t1.fault==t2.fault){
											if(t1.shotInRate==t2.shotInRate){
												if(t1.threeShotInRate==t2.threeShotInRate){
													if(t1.penaltyShotInRate==t2.penaltyShotInRate){
														if(t1.defensiveRebound==t2.defensiveRebound){
															if(t1.offensiveRebound==t2.offensiveRebound){
																return 0;
															}
															return t1.offensiveRebound-t2.offensiveRebound;
														}
														return t1.defensiveRebound-t2.defensiveRebound;
													}
													return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
												}
												return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
											}
											return (t1.shotInRate-t2.shotInRate)>0?1:-1;
										}
										return t1.fault-t2.fault;
									}
									return t1.foul-t2.foul;
								}
								return t1.steal-t2.steal;
							}
							return t1.blockShot-t2.blockShot;
						}
						return t1.secondaryAttack-t2.secondaryAttack;
					case blockShot:
						if(t1.blockShot==t2.blockShot){
							if(t1.steal==t2.steal){
								if(t1.foul==t2.foul){
									if(t1.fault==t2.fault){
										if(t1.shotInRate==t2.shotInRate){
											if(t1.threeShotInRate==t2.threeShotInRate){
												if(t1.penaltyShotInRate==t2.penaltyShotInRate){
													if(t1.defensiveRebound==t2.defensiveRebound){
														if(t1.offensiveRebound==t2.offensiveRebound){
															return 0;
														}
														return t1.offensiveRebound-t2.offensiveRebound;
													}
													return t1.defensiveRebound-t2.defensiveRebound;
												}
												return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
											}
											return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
										}
										return (t1.shotInRate-t2.shotInRate)>0?1:-1;
									}
									return t1.fault-t2.fault;
								}
								return t1.foul-t2.foul;
							}
							return t1.steal-t2.steal;
						}
						return t1.blockShot-t2.blockShot;
					case steal:
						if(t1.steal==t2.steal){
							if(t1.foul==t2.foul){
								if(t1.fault==t2.fault){
									if(t1.shotInRate==t2.shotInRate){
										if(t1.threeShotInRate==t2.threeShotInRate){
											if(t1.penaltyShotInRate==t2.penaltyShotInRate){
												if(t1.defensiveRebound==t2.defensiveRebound){
													if(t1.offensiveRebound==t2.offensiveRebound){
														return 0;
													}
													return t1.offensiveRebound-t2.offensiveRebound;
												}
												return t1.defensiveRebound-t2.defensiveRebound;
											}
											return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
										}
										return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
									}
									return (t1.shotInRate-t2.shotInRate)>0?1:-1;
								}
								return t1.fault-t2.fault;
							}
							return t1.foul-t2.foul;
						}
						return t1.steal-t2.steal;
					case foul:
						if(t1.foul==t2.foul){
							if(t1.fault==t2.fault){
								if(t1.shotInRate==t2.shotInRate){
									if(t1.threeShotInRate==t2.threeShotInRate){
										if(t1.penaltyShotInRate==t2.penaltyShotInRate){
											if(t1.defensiveRebound==t2.defensiveRebound){
												if(t1.offensiveRebound==t2.offensiveRebound){
													return 0;
												}
												return t1.offensiveRebound-t2.offensiveRebound;
											}
											return t1.defensiveRebound-t2.defensiveRebound;
										}
										return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
									}
									return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
								}
								return (t1.shotInRate-t2.shotInRate)>0?1:-1;
							}
							return t1.fault-t2.fault;
						}
						return t1.foul-t2.foul;
					case fault:
						if(t1.fault==t2.fault){
							if(t1.shotInRate==t2.shotInRate){
								if(t1.threeShotInRate==t2.threeShotInRate){
									if(t1.penaltyShotInRate==t2.penaltyShotInRate){
										if(t1.defensiveRebound==t2.defensiveRebound){
											if(t1.offensiveRebound==t2.offensiveRebound){
												return 0;
											}
											return t1.offensiveRebound-t2.offensiveRebound;
										}
										return t1.defensiveRebound-t2.defensiveRebound;
									}
									return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
								}
								return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
							}
							return (t1.shotInRate-t2.shotInRate)>0?1:-1;
						}
						return t1.fault-t2.fault;
					case shotInRate:
						if(t1.shotInRate==t2.shotInRate){
							if(t1.threeShotInRate==t2.threeShotInRate){
								if(t1.penaltyShotInRate==t2.penaltyShotInRate){
									if(t1.defensiveRebound==t2.defensiveRebound){
										if(t1.offensiveRebound==t2.offensiveRebound){
											return 0;
										}
										return t1.offensiveRebound-t2.offensiveRebound;
									}
									return t1.defensiveRebound-t2.defensiveRebound;
								}
								return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
							}
							return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
						}
						return (t1.shotInRate-t2.shotInRate)>0?1:-1;
					case threeShotInRate:
						if(t1.threeShotInRate==t2.threeShotInRate){
							if(t1.penaltyShotInRate==t2.penaltyShotInRate){
								if(t1.defensiveRebound==t2.defensiveRebound){
									if(t1.offensiveRebound==t2.offensiveRebound){
										return 0;
									}
									return t1.offensiveRebound-t2.offensiveRebound;
								}
								return t1.defensiveRebound-t2.defensiveRebound;
							}
							return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
						}
						return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
					case penaltyShotInRate:
						if(t1.penaltyShotInRate==t2.penaltyShotInRate){
							if(t1.defensiveRebound==t2.defensiveRebound){
								if(t1.offensiveRebound==t2.offensiveRebound){
									return 0;
								}
								return t1.offensiveRebound-t2.offensiveRebound;
							}
							return t1.defensiveRebound-t2.defensiveRebound;
						}
						return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
					case defensiveRebound:
						if(t1.defensiveRebound==t2.defensiveRebound){
							if(t1.offensiveRebound==t2.offensiveRebound){
								return 0;
							}
							return t1.offensiveRebound-t2.offensiveRebound;
						}
						return t1.defensiveRebound-t2.defensiveRebound;
					case offensiveRebound:
						return t1.offensiveRebound-t2.offensiveRebound;
					default:
						return 0;
					}
				}

			};
			
			Collections.sort(forSort, comparator);
			return forSort;
		}else{
			Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
				public int compare(TeamTechLineItem t2, TeamTechLineItem t1){
					switch(DataType){
					case winningRate:
						if(t1.winningRate==t2.winningRate){
							if(t1.offensiveRound==t2.offensiveRound){
								if(t1.offensiveEfficiency==t2.offensiveEfficiency){
									if(t1.defensiveEfficiency==t2.defensiveEfficiency){
										if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
											if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
												if(t1.stealEfficiency==t2.stealEfficiency){
													if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
														return 0;
													}
													return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
												}
												return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
											}
											return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
										}
										return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
									}
									return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
								}
								return (t1.offensiveEfficiency-t2.offensiveEfficiency)>0?1:-1;
							}
							return (t1.offensiveRound-t2.offensiveRound)>0?1:-1;
						}
						return (t1.winningRate-t2.winningRate)>0?1:-1;
					case offensiveRound:
						if(t1.offensiveRound==t2.offensiveRound){
							if(t1.offensiveEfficiency==t2.offensiveEfficiency){
								if(t1.defensiveEfficiency==t2.defensiveEfficiency){
									if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
										if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
											if(t1.stealEfficiency==t2.stealEfficiency){
												if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
													return 0;
												}
												return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
											}
											return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
										}
										return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
									}
									return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
								}
								return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
							}
							return (t1.offensiveEfficiency-t2.offensiveEfficiency)>0?1:-1;
						}
						return (t1.offensiveRound-t2.offensiveRound)>0?1:-1;
					case offensiveEfficiency:
						if(t1.offensiveEfficiency==t2.offensiveEfficiency){
							if(t1.defensiveEfficiency==t2.defensiveEfficiency){
								if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
									if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
										if(t1.stealEfficiency==t2.stealEfficiency){
											if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
												return 0;
											}
											return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
										}
										return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
									}
									return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
								}
								return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
							}
							return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
						}
						return (t1.offensiveEfficiency-t2.offensiveEfficiency)>0?1:-1;
					case defensiveEfficiency:
						if(t1.defensiveEfficiency==t2.defensiveEfficiency){
							if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
								if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
									if(t1.stealEfficiency==t2.stealEfficiency){
										if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
											return 0;
										}
										return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
									}
									return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
								}
								return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
							}
							return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
						}
						return (t1.defensiveEfficiency-t2.defensiveEfficiency)>0?1:-1;
					case offensiveReboundEfficiency:
						if(t1.offensiveReboundEfficiency==t2.offensiveReboundEfficiency){
							if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
								if(t1.stealEfficiency==t2.stealEfficiency){
									if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
										return 0;
									}
									return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
								}
								return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
							}
							return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
						}
						return (t1.offensiveReboundEfficiency-t2.offensiveReboundEfficiency)>0?1:-1;
					case defensiveReboundEfficiency:
						if(t1.defensiveReboundEfficiency==t2.defensiveReboundEfficiency){
							if(t1.stealEfficiency==t2.stealEfficiency){
								if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
									return 0;
								}
								return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
							}
							return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
						}
						return (t1.defensiveReboundEfficiency-t2.defensiveReboundEfficiency)>0?1:-1;
					case stealEfficiency:
						if(t1.stealEfficiency==t2.stealEfficiency){
							if(t1.secondaryAttackEfficiency==t2.secondaryAttackEfficiency){
								return 0;
							}
							return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
						}
						return (t1.stealEfficiency-t2.stealEfficiency)>0?1:-1;
					case secondaryAttackEfficiency:
						return (t1.secondaryAttackEfficiency-t2.secondaryAttackEfficiency)>0?1:-1;
					default:
						return 0;
					}
				}
			};
			Collections.sort(forSort, comparator);
			return forSort;
		}
	}

	public ArrayList<TeamTechLineItem> findSeasonHotTeam(TeamTechEnum DataType) {
		ArrayList<TeamTechPO> list = new ArrayList<TeamTechPO>();
		ArrayList<TeamTechLineItem> forSort = new ArrayList<TeamTechLineItem>();
		for(int i = 0; i<30; i++){
			TeamTechP2L p2l = new TeamTechP2L();
			forSort.add(p2l.p2l(list.get(i)));
		}
		Comparator<TeamTechLineItem> comparator = new Comparator<TeamTechLineItem>(){
			public int compare(TeamTechLineItem t2, TeamTechLineItem t1){
				switch(DataType){
				case score:
					return (t1.scoreave-t2.scoreave)>0?1:-1;
				case rebound:
					return (t1.reboundave-t2.reboundave)>0?1:-1;
				case secondaryAttack:
					return (t1.secondaryAttackave-t2.secondaryAttackave)>0?1:-1;
				case blockShot:
					return (t1.blockShotave-t2.blockShotave)>0?1:-1;
				case steal:
					return (t1.stealave-t2.stealave)>0?1:-1;
				case foul:
					return (t1.foulave-t2.foulave)>0?1:-1;
				case fault:
					return (t1.faultave-t2.faultave)>0?1:-1;
				case shotInRate:
					return (t1.shotInRate-t2.shotInRate)>0?1:-1;
				case threeShotInRate:
					return (t1.threeShotInRate-t2.threeShotInRate)>0?1:-1;
				case penaltyShotInRate:
					return (t1.penaltyShotInRate-t2.penaltyShotInRate)>0?1:-1;
				case offensiveRebound:
					return (t1.offensiveReboundave-t2.offensiveReboundave)>0?1:-1;
				case defensiveRebound:
					return (t1.defensiveReboundave-t2.defensiveReboundave)>0?1:-1;
				default:return 0;
				}
			}
		};
		Collections.sort(forSort, comparator);
		return forSort;
	}
	
	public void init() {
		// TODO Auto-generated method stub
		ttds.WriteIn();
	}
	
	
}
